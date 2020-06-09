package com.colorful.nuoche;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;

/**
 * Hello world!
 *
 */

@SpringBootApplication
@Controller
public class App {

	public static void main(String[] args) {
		// System.out.println("Hello World!");
		SpringApplication.run(App.class, args);
	}



}
