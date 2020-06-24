package com.colorful.nuoche.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.colorful.nuoche.service.WechatUserInfoService;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author yangjin
 * @since 2020-06-24
 */
@RestController
@RequestMapping("/weChat")
public class WechatUserInfoController {
	
	@Autowired
	private WechatUserInfoService wechatUserInfoService;
	
	

}
