package com.dyb.yanbangbang;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.dyb.yanbangbang.mapper")
@SpringBootApplication
public class YanbangbangApplication {

	public static void main(String[] args) {
		SpringApplication.run(YanbangbangApplication.class, args);
	}

}

