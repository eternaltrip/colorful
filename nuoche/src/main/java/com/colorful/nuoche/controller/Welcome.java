package com.colorful.nuoche.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import io.swagger.annotations.ApiOperation;


@Controller
public class Welcome {
	
	@ApiOperation("欢迎页面")
	@RequestMapping(value="/",method = RequestMethod.GET)
	@ResponseBody
	public Object welcome() {
		return "Hello ,Nuoche!";
	}
	
}
	

