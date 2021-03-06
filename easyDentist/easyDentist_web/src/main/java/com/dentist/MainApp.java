package com.dentist;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(value = {"com.dentist.mapper"})
public class MainApp {
	
		public static void main(String[] args) {
			SpringApplication.run(MainApp.class, args);
	}

}
