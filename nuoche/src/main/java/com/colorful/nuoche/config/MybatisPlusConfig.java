package com.colorful.nuoche.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;


@Configuration
public class MybatisPlusConfig {

	/**
	 * 分页插件
	 * 
	 * @return com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor
	 */
	@Bean
	public PaginationInterceptor paginationInterceptor() {
		return new PaginationInterceptor();
	}
}
