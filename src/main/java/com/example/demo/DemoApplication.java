package com.example.demo;/////�i�D�A�o���ɮש�b��

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

							// ���Ȯɧ�spring security���w�]�n�������ư�
@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class DemoApplication {

////////�o��main�O���M�ת��J�f�I�A�򥻤W���n�ʨ�L
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);

	}
}
