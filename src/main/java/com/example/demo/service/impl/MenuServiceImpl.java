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
	@Autowired // ��U�ު��F�讳�ӥ�
	private MenuDao menuDao;

	@Override
	public Menu addMenu(Menu menu) {
//		menuDao.save(menu);
		// ���ˬd�W�٨ϧ_null�B����ϧ_<=0
		if (!StringUtils.hasText(menu.getName()) || menu.getPrive() <= 0) {
			return null;
		}
		//�s�W�N���s�W���ơA�p�G�s�b�A�|�ܧ�s
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
//		System.out.println("�»���"+findOp.get().getName()+":"+findOp.get().getPrive());
//		menuDao.save(menu);
//		System.out.println("�s����"+menu.getName()+":"+menu.getPrive());

		// �Ѽ��ˬd�W�ٻ���
		if (!StringUtils.hasText(menu.getName()) || menu.getPrive() <= 0) {
			return null;
		}
		// �ˬd�O�_�s�b�A�Y���s�b�x�s�N�|�ܷs�W
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

		// �ˬd�r��O�_����
		if (name.isEmpty()) {
			return null;
		}
		if(menuDao.existsById(name)) {
			return findOp.get();			
		}
		return null;

	}

// 		return name.isEmpty() ? null : findOp.get(); //�T�����g�k�A�ȾA��2��1���p
//		return findOp.orElseGet(null); //OP�~���� 
	
	@Override
	public List<Menu> findAll() {
//		List<Menu> list = new ArrayList<>(menuDao.findAll());
//		for (Menu item : list) {
//			System.out.println(item.getName() + "�G" + item.getPrive());
//		}

		return menuDao.findAll();
	}

}
