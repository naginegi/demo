package com.example.demo.entity;

public class Cat extends Animal {
				// �O�o extends �����O *�ܭ��n
	
	/*
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Override // �ߺD�[
	public void eat() {
		System.out.println("�Y��");
	}
	 */
	
	@Override // �ߺD�[
	public void sleep() {
		System.out.println("�ΰ�");
	}
	
	public void meow() {
		System.out.println("meow meow meow");
	}
	
}
