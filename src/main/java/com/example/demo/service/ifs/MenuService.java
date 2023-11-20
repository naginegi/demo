package com.example.demo.service.ifs;

import java.util.List;

import com.example.demo.entity.Menu;

public interface MenuService {
	
	public Menu addMenu(Menu menu);
	
	public List<Menu> addMenuList(List<Menu> menus);
	
	public Menu updataMenu(Menu menu);
	
	public Menu findByName(String name);
	
	public List<Menu> findAll();
	
	
}
