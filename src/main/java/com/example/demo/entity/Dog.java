package com.example.demo.entity;

import com.example.demo.service.ifs.RunService;

/*
���O�P����
JAVA�Ҧ��F�賣��٬�����
���󪺯S�ʺ� �ݩ� --> �۹�� �H�������~�ֵ�
���󪺦欰�� ��k --> �۹�� �H�������M����
*/

public class Dog implements RunService{

	// �u���b���O���U���ݩʵ��v��(private)
	// ��k�̪��ܼƤ���[�v��
	// �U���ݩʶ��[enter��}�A��K�\Ū
	// ���ݩ� set get
	// public �s�����v���̤j�A�i�b�Ҧ��a��s��
	// private �s�����v���̤p�A�u��b�Ҧb���a��
	
	private String name = "dog";

	private String color;

	private int age;
	
	
	//�w�]�غc��k
	//�ťզa��k��-->source-->Generate Constructor from superclass
	public Dog() {
		super();//�Ω��~��
	}
	
	//�a���Ѽƪ��غc��k�A���j�w�W��"�w�]�غc��k"
	//�ťզa��k��-->source-->Generate Constructor using Fields
	public Dog(String name, String color, int age) {
		super();
		this.name = name;
		this.color = color;
		this.age = age;
	}

	//���}��k
	//�ťզa��k��-->source-->Generate Getters and Setters
	//set : void�L�^�ǪF��Cget �G �|�^�Ǩ������O���F�� 
	public String getName() {
		return name;
	}
	

	public void setName(String name) {
		this.name = name;//�[this����]�G�Ϥ����ӬO����name
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	
	public void setAttributes() {

	}
	
	public static void setAttributes2() {
		
	}

	@Override
	public void run() {
		System.out.println(" �� �]");
		
	}
}
