package com.colorful.nuoche;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Hello world!
 *
 */



@SpringBootApplication
@Controller
public class App {
	
	public static void main(String[] args) {
		//System.out.println("Hello World!");
		SpringApplication.run(App.class, args);
	}
	
	@RequestMapping("/")
	@ResponseBody
	public Object welcome() {
		return "Hello ,Nuoche!";
	}
	
}
