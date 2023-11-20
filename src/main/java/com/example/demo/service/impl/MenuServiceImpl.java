package com.example.demo.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.example.demo.entity.Menu;
import com.example.demo.repository.MenuDao;
import com.example.demo.service.ifs.MenuService;

@Service
public class MenuServiceImpl implements MenuService {

	// @: annotation
	@Autowired // 把託管的東西拿來用
	private MenuDao menuDao;

	@Override
	public Menu addMenu(Menu menu) {
//		menuDao.save(menu);
		// 先檢查名稱使否null、價格使否<=0
		if (!StringUtils.hasText(menu.getName()) || menu.getPrive() <= 0) {
			return null;
		}
		//新增就做新增的事，如果存在，會變更新
		if (menuDao.existsById(menu.getName())) {
			return null;
		}
		return menuDao.save(menu);
	}

	@Override
	public List<Menu> addMenuList(List<Menu> menus) {
		for (Menu item : menus) {
			if (!StringUtils.hasText(item.getName()) || item.getPrive() <= 0) {
				return null;
			}
		}
		return menuDao.saveAll(menus);
	}

	@Override
	public Menu updataMenu(Menu menu) {
//		Optional<Menu> findOp = menuDao.findById(menu.getName());
//		System.out.println("舊價錢"+findOp.get().getName()+":"+findOp.get().getPrive());
//		menuDao.save(menu);
//		System.out.println("新價錢"+menu.getName()+":"+menu.getPrive());

		// 參數檢查名稱價格
		if (!StringUtils.hasText(menu.getName()) || menu.getPrive() <= 0) {
			return null;
		}
		// 檢查是否存在，若不存在儲存就會變新增
		if (menuDao.existsById(menu.getName())) {
//			System.out.println(menu.getName());
			return menuDao.save(menu);
		}
		return null;

	}

	@Override
	public Menu findByName(String name) {
//		if (menuDao.existsById(name)) {
//
//			Optional<Menu> findOp = menuDao.findById(name);
//			System.out.println(findOp.get().getName() + ":" + findOp.get().getPrive());
//		} else {
//			System.out.println("Not found");
//		}
		Optional<Menu> findOp = menuDao.findById(name);

		// 檢查字串是否為空
		if (name.isEmpty()) {
			return null;
		}
		if(menuDao.existsById(name)) {
			return findOp.get();			
		}
		return null;

	}

// 		return name.isEmpty() ? null : findOp.get(); //三元式寫法，僅適用2擇1情況
//		return findOp.orElseGet(null); //OP才有的 
	
	@Override
	public List<Menu> findAll() {
//		List<Menu> list = new ArrayList<>(menuDao.findAll());
//		for (Menu item : list) {
//			System.out.println(item.getName() + "：" + item.getPrive());
//		}

		return menuDao.findAll();
	}

}
