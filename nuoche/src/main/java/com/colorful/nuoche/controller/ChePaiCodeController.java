package com.colorful.nuoche.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.colorful.nuoche.compent.ChepaiCodeCompent;
import com.colorful.nuoche.entity.common.ResponseDataUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = "车牌区域代码", description = "车牌区域代码相关接口")
@RestController
@RequestMapping(value = "/code")
public class ChePaiCodeController {
	
	
	@Autowired
	private ChepaiCodeCompent chepaiCode;



	@ApiOperation("获取车牌区域代码")
	@RequestMapping(value = "/chePaiCode", method = RequestMethod.GET)
	public Object code(HttpServletRequest request) throws IOException {
		
		return ResponseDataUtil.buildSuccess(chepaiCode.getChepaiCode());
	}

}
