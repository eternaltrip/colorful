package com.colorful.nuoche;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.transaction.annotation.EnableTransactionManagement;



//MyBatis 支持
@MapperScan("com.colorful.nuoche.mapper")
@EnableTransactionManagement
@SpringBootApplication
public class App extends SpringBootServletInitializer  {

	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}

	/**
	 * 方便读取resource下的文件，这里需要重写下方法
	 */
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(App.class);
	}
}
