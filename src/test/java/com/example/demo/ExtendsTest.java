package com.example.demo;

import javax.management.loading.PrivateClassLoader;

import org.junit.jupiter.api.Test;

import com.example.demo.entity.A;
import com.example.demo.entity.A1;
import com.example.demo.entity.Animal;
import com.example.demo.entity.Bird;
import com.example.demo.entity.C;
import com.example.demo.entity.Car;
import com.example.demo.entity.Cat;
import com.example.demo.entity.Dog;

public class ExtendsTest {

	@Test
	public void extendsTest() {
		System.out.println("====================");
		Animal ani = new Animal();
		System.out.println("�����O(Animal)");
		System.out.println("name�G" + ani.getName());
		ani.eat();
		ani.sleep();

		System.out.println("====================");
		System.out.println("�l���O(bird)");
		Bird bird = new Bird();// �b�Ұʤl���O���e�A�|���Ұʤ����O���غc��k
		System.out.println("oldName�G" + bird.getName());// �o�O�����O����k
		bird.setName("Huh");// �o�O�����O����k
		System.out.println("newName�G" + bird.getName());// �o�O�����O����k
		bird.eat();// �Y�l���O���P�W��k�A����l���O��k�A�]��@Override
		bird.sleep();
		bird.fly();// �o�O�l���O����k

		System.out.println("====================");
		System.out.println("�l���O(cat)");
		Cat cat = new Cat();
		System.out.println("name�G" + cat.getName());
		cat.eat(); // �����O��k
		cat.sleep(); // ���l�P�W��k�A�l���O@Override�A����l���O��k
		cat.meow(); // �l���O��k
	}

	@Test
	public void extendsTest1() {
		// �˴����l���Y
		Bird bird = new Bird();
		System.out.println((bird instanceof Animal));// true

	}

	@Test
	public void extendsTest2() {
		// �զX�A�ϥ�extends
		// ���l�h���Y�Ϊk
		A a = new A();
		a.setCity("789");
		System.out.println(a.getCity());

		// �E�X�A�S����extends�覡
		// getC��ܨ��oC�̪��ݩʤ�k�A��i��set get����k
		A1 a1 = new A1();
		a1.getC().setCity("777");
		System.out.println(a1.getC().getCity());

	}

	@Test
	public void extendsTest3() {
		// �w�]��k����
		C c = new C("aaa", "bbb", "ccc");
		// A1 �� setC �ϥΤ覡
		A1 a1 = new A1();
		a1.setC(c);
		System.out.println("city : " + a1.getC().getCity());
		System.out.println("state : " + a1.getC().getState());
		System.out.println("country : " + a1.getC().getCountry());

	}

	@Test
	public void extendsTest4() {
		// �h�� �e���Ŧr�s�������A �Τ����O���u��Τ����O��k�A��ڤW���檺�O�l���O����k

		Animal ani = new Animal();
		ani.eat(); // �������A�����O ����Animal����eat()

		Cat cat = new Cat();
		cat.eat(); // �������A�l���O���Leat() ����Animal����eat()

		Bird bird = new Bird();
		bird.eat();// �������A�l���O����eat() ����Bird����eat()

		System.out.println("=================");

		Animal anii = new Animal();
		anii.eat(); // �������A�����O ����Animal����eat()

		Animal catt = new Cat();
		catt.eat();
		// �������A�����O ����Animal����eat()
		// ���L�k����l���OCat����meow()

		Animal birdd = new Bird();
		birdd.eat();
		// �������A�����O ����Animal����eat()�A���l���O�����P�W��keat()
		// @Override ��|����l���O����@���e
		
		System.out.println("=================");

		Animal anim = new Animal();
		Animal ca = new Cat();
		Animal bir = new Bird();
		
		anim.aniAction(new Animal());
		anim.aniAction(ca);
		anim.aniAction(new Bird());
				
	}
	
	@Test
	public void extendsTest5() {
		//����
		Car car = new Car();
		car.run();
		Dog dog = new Dog();
		dog.run();
	}
}
