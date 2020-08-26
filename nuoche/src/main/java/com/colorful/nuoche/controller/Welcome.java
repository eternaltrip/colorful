package com.colorful.nuoche.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;

@RestController
public class Welcome {

	@ApiOperation("欢迎页面")
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public Object welcome() {
		return "Hello ,Nuoche!";
	}
}
