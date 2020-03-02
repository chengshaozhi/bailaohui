package com.junyang;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@MapperScan("com.junyang.dao")
@EnableScheduling
public class YiShiKongAPP {

	public static void main(String[] args) {
		SpringApplication.run(YiShiKongAPP.class, args);
	}
	
	

}
