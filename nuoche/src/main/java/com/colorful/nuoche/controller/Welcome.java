package com.colorful.nuoche.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;


@Controller
public class Welcome {
	@ApiOperation("欢迎页面")
	@ApiImplicitParam(name = "telephone", value = "电话号码", paramType = "query", required = true, dataType = "Integer")
	@RequestMapping(value="/",method = RequestMethod.GET)
	@ResponseBody
	public Object welcome() {
		return "Hello ,Nuoche!";
	}
	
	
	
	@ApiOperation(value="欢迎页面2",notes = "传入参数name，返回时显示")
	@ApiImplicitParam(name = "name", value = "姓名", paramType = "query", required = true, dataType = "String")
	@RequestMapping(value="/2",method = RequestMethod.GET)
	@ResponseBody
	public Object welcome2(String name) {
		return "Hello , " + name;
	}
}
