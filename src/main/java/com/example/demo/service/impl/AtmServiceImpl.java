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
			// �q�`�b���K�X�����K��Ƥ��|��������
			return new AtmResponse(null, RtnCode.PARAM_ERROR);
		}
		if (atmDao.existsById(account)) {
			return new AtmResponse(null, RtnCode.ACCOUNT_EXISTED);
		}
		// �إ߱K��r��
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		Atm res = atmDao.save(new Atm(account, encoder.encode(pwd)));
		// ����ܦ^�ǱK�X
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
		// �b�^�Ǯɷ|�s�K�X�]�@�_�^�ǡA�ҥH���X�ӱK���K�X�A�קK�|�}
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
		// �ˬd��J
		if (StringUtils.hasText(account) || StringUtils.hasText(oldpwd) || StringUtils.hasText(newpwd)) {
			return new AtmResponse(null, RtnCode.PARAM_ERROR);
		}

		// ����Ʈw�̸��
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		Optional<Atm> op = atmDao.findById(account);
		Atm res = op.get();
		// �ˬd��J���±K�X�O�_�P��Ʈw�̪��K�X�ۦP�A�O�~���
		if (!encoder.matches(oldpwd, res.getPwd())) {
			return new AtmResponse(null, RtnCode.ACCOUNT_NOTFOUNT);
		}

		// �]�w�s���K�X�A�M��[�K�B�x�s
		res.setPwd(encoder.encode(newpwd));
		atmDao.save(res);

		// ���^�Ǫ��K�X�O�šA���K�X�w�g�s�i��Ʈw��
		res.setPwd("");
		return new AtmResponse(res, RtnCode.SUCCESSFUL);
	}

	@Override
	public AtmResponse deposit(String account, String pwd, int balance) {
		// �ˬd��J
		if (!StringUtils.hasText(account) || !StringUtils.hasText(pwd) || balance <= 0) {
			return new AtmResponse(null, RtnCode.PARAM_ERROR);
		}

		// ����Ʈw�̸��
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		Optional<Atm> op = atmDao.findById(account);

		// �ˬd�b���O�_�s�b
		if (op.isEmpty()) {
			return new AtmResponse(null, RtnCode.ACCOUNT_NOTFOUNT);
		}

		// �ˬd��J���±K�X�O�_�P��Ʈw�̪��K�X�ۦP�A�O�~���
		Atm res = op.get();
		if (!encoder.matches(pwd, res.getPwd())) {
			return new AtmResponse(null, RtnCode.ACCOUNT_NOTFOUNT);
		}
		// �s��
		res.setbalance(res.getbalance() + balance);
		atmDao.save(res);
		res.setPwd("");
		return new AtmResponse(res, RtnCode.SUCCESSFUL);
	}

	@Override
	public AtmResponse withdraw(String account, String pwd, int balance) {
		// �ˬd��J
		if (!StringUtils.hasText(account) || !StringUtils.hasText(pwd) || balance <= 0) {
			return new AtmResponse(null, RtnCode.PARAM_ERROR);
		}

		// ����Ʈw�̸��
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		Optional<Atm> op = atmDao.findById(account);

		// �ˬd�b���O�_�s�b
		if (op.isEmpty()) {
			return new AtmResponse(null, RtnCode.ACCOUNT_NOTFOUNT);
		}

		// �ˬd��J���±K�X�O�_�P��Ʈw�̪��K�X�ۦP�A�O�~���
		Atm res = op.get();
		if (!encoder.matches(pwd, res.getPwd())) {
			return new AtmResponse(null, RtnCode.ACCOUNT_NOTFOUNT);
		}

		// �ˬd�l�B
		if (res.getbalance() < balance) {
			return new AtmResponse(null, RtnCode.BALANCE_IS_INSUFFICIENT);
		}
		// ����
		System.out.println(res.getAccount() + ":" + res.getbalance());
		res.setbalance(res.getbalance() - balance);
		atmDao.save(res);
		res.setPwd("");
		return new AtmResponse(res, RtnCode.SUCCESSFUL);

	}
}
