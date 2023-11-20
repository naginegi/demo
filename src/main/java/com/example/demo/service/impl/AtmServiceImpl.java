package com.example.demo.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.example.demo.constants.RtnCode;
import com.example.demo.entity.Atm;
import com.example.demo.repository.AtmDao;
import com.example.demo.service.ifs.AtmService;
import com.example.demo.vo.AtmResponse;

@Service
public class AtmServiceImpl implements AtmService {

	@Autowired
	private AtmDao atmDao;

	@Override
	public AtmResponse addInfo(String account, String pwd) {
		if (!StringUtils.hasText(account) || !StringUtils.hasText(pwd)) {
			// 通常帳號密碼等機密資料不會細講哪錯
			return new AtmResponse(null, RtnCode.PARAM_ERROR);
		}
		if (atmDao.existsById(account)) {
			return new AtmResponse(null, RtnCode.ACCOUNT_EXISTED);
		}
		// 建立密文字串
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		Atm res = atmDao.save(new Atm(account, encoder.encode(pwd)));
		// 不顯示回傳密碼
		res.setPwd("");
		//
		return new AtmResponse(res, RtnCode.SUCCESSFUL);
	}

	@Override
	public AtmResponse getBalanceByAccount(String account, String pwd) {
		if (!StringUtils.hasText(account)) {
			return new AtmResponse(null, RtnCode.PARAM_ERROR);
		}
		Optional<Atm> op = atmDao.findById(account);
		if (op.isEmpty()) {
			return new AtmResponse(null, RtnCode.ACCOUNT_NOTFOUNT);
		}
		// 在回傳時會連密碼也一起回傳，所以取出來密掉密碼，避免漏洞
		Atm res = op.get();
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		if (!encoder.matches(pwd, res.getPwd())) {
			return new AtmResponse(null, RtnCode.ACCOUNT_NOTFOUNT);
		}
		res.setPwd("");
		return new AtmResponse(res, RtnCode.SUCCESSFUL);

	}

	@Override
	public AtmResponse updataPwd(String account, String oldpwd, String newpwd) {
		// 檢查輸入
		if (StringUtils.hasText(account) || StringUtils.hasText(oldpwd) || StringUtils.hasText(newpwd)) {
			return new AtmResponse(null, RtnCode.PARAM_ERROR);
		}

		// 取資料庫裡資料
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		Optional<Atm> op = atmDao.findById(account);
		Atm res = op.get();
		// 檢查輸入的舊密碼是否與資料庫裡的密碼相同，是才能改
		if (!encoder.matches(oldpwd, res.getPwd())) {
			return new AtmResponse(null, RtnCode.ACCOUNT_NOTFOUNT);
		}

		// 設定新的密碼，然後加密、儲存
		res.setPwd(encoder.encode(newpwd));
		atmDao.save(res);

		// 讓回傳的密碼是空，但密碼已經存進資料庫裡
		res.setPwd("");
		return new AtmResponse(res, RtnCode.SUCCESSFUL);
	}

	@Override
	public AtmResponse deposit(String account, String pwd, int balance) {
		// 檢查輸入
		if (!StringUtils.hasText(account) || !StringUtils.hasText(pwd) || balance <= 0) {
			return new AtmResponse(null, RtnCode.PARAM_ERROR);
		}

		// 取資料庫裡資料
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		Optional<Atm> op = atmDao.findById(account);

		// 檢查帳號是否存在
		if (op.isEmpty()) {
			return new AtmResponse(null, RtnCode.ACCOUNT_NOTFOUNT);
		}

		// 檢查輸入的舊密碼是否與資料庫裡的密碼相同，是才能改
		Atm res = op.get();
		if (!encoder.matches(pwd, res.getPwd())) {
			return new AtmResponse(null, RtnCode.ACCOUNT_NOTFOUNT);
		}
		// 存款
		res.setbalance(res.getbalance() + balance);
		atmDao.save(res);
		res.setPwd("");
		return new AtmResponse(res, RtnCode.SUCCESSFUL);
	}

	@Override
	public AtmResponse withdraw(String account, String pwd, int balance) {
		// 檢查輸入
		if (!StringUtils.hasText(account) || !StringUtils.hasText(pwd) || balance <= 0) {
			return new AtmResponse(null, RtnCode.PARAM_ERROR);
		}

		// 取資料庫裡資料
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		Optional<Atm> op = atmDao.findById(account);

		// 檢查帳號是否存在
		if (op.isEmpty()) {
			return new AtmResponse(null, RtnCode.ACCOUNT_NOTFOUNT);
		}

		// 檢查輸入的舊密碼是否與資料庫裡的密碼相同，是才能改
		Atm res = op.get();
		if (!encoder.matches(pwd, res.getPwd())) {
			return new AtmResponse(null, RtnCode.ACCOUNT_NOTFOUNT);
		}

		// 檢查餘額
		if (res.getbalance() < balance) {
			return new AtmResponse(null, RtnCode.BALANCE_IS_INSUFFICIENT);
		}
		// 提款
		System.out.println(res.getAccount() + ":" + res.getbalance());
		res.setbalance(res.getbalance() - balance);
		atmDao.save(res);
		res.setPwd("");
		return new AtmResponse(res, RtnCode.SUCCESSFUL);

	}
}
