package com.example.demo.entity;

public class Bird extends Animal {
				  // �O�o extends �����O *�ܭ��n
	/*
	//�� �����O(Animal) ���ƪ��ݩʤ�k
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	 */

	public Bird() {
		//�bnew���ɭԷ|�ʧ@
		super();
//		System.out.println("Bird �غc��k");
		//�l�q����
//		int a = super.age+5;
//		System.out.println(this.age);
//		System.out.println(a);
	}
	
	// �Ƽg�л\�A���s�w�q
	// ���l���O ��P�W��k+�ѼƭӼơA�l���O���s�w�q{ }����k
	// java 9 ����i���[Override ���ߺD�|�[�A��ܤ����O���ۦP��k
	

	@Override 
	public void eat() {
		System.out.println(super.getName()+" �b�Y�ճܰ�");
	}

	@Override 
	public void sleep() {
		System.out.println(super.getName()+" �b�ΰխ���");
	}
	
	public void fly() {
		//�l�h��k�����h�ݩ�
		System.out.println(super.getName()+" �bflying");
	}
}
