package com.example.mybatisredis;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan(basePackages = {"com.example.mybatisredis.Mapper"})
@SpringBootApplication
public class MybatisRedisApplication {

	public static void main(String[] args) {
		SpringApplication.run(MybatisRedisApplication.class, args);
	}
}
