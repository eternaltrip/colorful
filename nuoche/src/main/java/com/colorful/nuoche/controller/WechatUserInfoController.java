package com.colorful.nuoche.controller;


import java.time.LocalDateTime;
import java.util.UUID;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.segments.MergeSegments;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.colorful.nuoche.entity.WechatUserInfo;
import com.colorful.nuoche.entity.common.ResponseDataUtil;
import com.colorful.nuoche.service.WechatUserInfoService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 *
 * @author yangjin
 * @since 2020-06-24
 */
@Api(tags="微信用户信息" , description = "相关接口")
@RestController
@RequestMapping("/weChat")
public class WechatUserInfoController {
	
	@Autowired
	private WechatUserInfoService wechatUserInfoService;
	
	
	@ApiOperation("微信用户信息保存")
	@ApiParam(name="wechatUserInfo" , value="微信用户信息",required = true)
	@PostMapping("/saveUserInfo")
	public Object wechatInfo(@ModelAttribute WechatUserInfo wechatUserInfo) {
		try {
			if(wechatUserInfo != null && StringUtils.isNotBlank(wechatUserInfo.getOpenId())) {
				UpdateWrapper<WechatUserInfo> updateWrapper = new UpdateWrapper<WechatUserInfo>();
				updateWrapper.eq("OPEN_ID", wechatUserInfo.getOpenId());
				if(StringUtils.isBlank(wechatUserInfo.getId())) {
					wechatUserInfo.setId(UUID.randomUUID().toString());
					wechatUserInfo.setCreateBy("user");
					wechatUserInfo.setCreateTime(LocalDateTime.now());
				}else {
					wechatUserInfo.setUpdateBy("user");
					wechatUserInfo.setUpdateTime(LocalDateTime.now());
				}
				wechatUserInfoService.saveOrUpdate(wechatUserInfo,updateWrapper);
				return ResponseDataUtil.buildSuccess("用户信息保存成功");
			}
			return ResponseDataUtil.buildError("数据不能为空！");
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseDataUtil.buildError("用户信息保存失败");
		}
	}
	
	
	@ApiOperation("获取微信用户信息")
	@ApiImplicitParam(name = "openId", value = "微信用户信息openId", paramType ="query" ,  dataType = "String" ,required = true)
	@GetMapping("/getWechatInfo")
	public Object getWechatInfo(@RequestParam() String openId) {
		try {
			WechatUserInfo wechatUserInfo = wechatUserInfoService.query().eq("OPEN_ID", openId).one();
			return ResponseDataUtil.buildSuccess(wechatUserInfo);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseDataUtil.buildError("获取用户信息失败");
		}
	}

}
