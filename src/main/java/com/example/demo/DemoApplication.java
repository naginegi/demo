package com.example.demo;/////告訴你這隻檔案放在哪

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

							// 先暫時把spring security的預設登陸頁面排除
@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class DemoApplication {

////////這個main是此專案的入口點，基本上不要動到他
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);

	}
}
