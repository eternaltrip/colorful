package com.colorful.nuoche.controller;


import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.UUID;

import org.apache.commons.lang3.StringUtils;
import org.apache.tomcat.util.json.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.druid.support.json.JSONUtils;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.colorful.nuoche.common.units.wechat.getOpenId;
import com.colorful.nuoche.entity.WechatUserInfo;
import com.colorful.nuoche.entity.common.ResponseDataUtil;
import com.colorful.nuoche.service.WechatUserInfoService;
import com.fasterxml.jackson.databind.util.JSONPObject;

import io.lettuce.core.dynamic.annotation.Param;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
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
	
	
	
	@ApiOperation("获取微信用户openId")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "appid", value = "appid", paramType = "query",  dataType = "String" ,required = true),
		@ApiImplicitParam(name = "secret", value = "secret", paramType = "query",  dataType = "String",required = true),
		@ApiImplicitParam(name = "js_code", value = "js_code", paramType = "query",  dataType = "String",required = true)
	})
	@PostMapping("/openId")
	public Object openId(@Param("appid") String appid , @Param("secret") String secret , @Param("js_code") String js_code ) {
		LinkedHashMap<String, String> openIdObj = getOpenId(appid,secret,js_code);
		//从json字符串获取openid和session_key
//		String openid=openIdObj.get("openid");
//		String session_key=openIdObj.get("session_key");
		return ResponseDataUtil.buildSuccess(openIdObj);
	}
	
	
	
	
	
	/*
	 * @ApiOperation("微信用户信息保存")
	 * 
	 * @ApiImplicitParams({
	 * 
	 * @ApiImplicitParam(name = "wechatUserInfo", value = "微信用户信息", paramType =
	 * "query", dataType = "String" ,required = true),
	 * 
	 * @ApiImplicitParam(name = "appid", value = "appid", paramType = "query",
	 * dataType = "String" ,required = true),
	 * 
	 * @ApiImplicitParam(name = "secret", value = "secret", paramType = "query",
	 * dataType = "String",required = true),
	 * 
	 * @ApiImplicitParam(name = "js_code", value = "js_code", paramType = "query",
	 * dataType = "String",required = true) })
	 * 
	 * @PostMapping("/saveUserInfo") public Object wechatInfo(@ModelAttribute
	 * WechatUserInfo wechatUserInfo,
	 * 
	 * @Param("appid") String appid ,
	 * 
	 * @Param("secret") String secret ,
	 * 
	 * @Param("js_code") String js_code) { try { getOpenId getopenid=new
	 * getOpenId(); //调用访问微信服务器工具方法，传入三个参数获取带有openid、session_key的json字符串 String
	 * jsonId=getopenid.getopenid(appid,js_code,secret); LinkedHashMap<String,
	 * String> openIdObj= (LinkedHashMap<String, String>) JSONUtils.parse(jsonId);
	 * //从json字符串获取openid和session_key String openid=openIdObj.get("openid"); String
	 * session_key=openIdObj.get("session_key");
	 * 
	 * 
	 * if(wechatUserInfo != null &&
	 * StringUtils.isNotBlank(wechatUserInfo.getOpenId())) {
	 * UpdateWrapper<WechatUserInfo> updateWrapper = new
	 * UpdateWrapper<WechatUserInfo>(); updateWrapper.eq("OPEN_ID",
	 * wechatUserInfo.getOpenId()); if(StringUtils.isBlank(wechatUserInfo.getId()))
	 * { wechatUserInfo.setId(UUID.randomUUID().toString());
	 * wechatUserInfo.setCreateBy("user");
	 * wechatUserInfo.setCreateTime(LocalDateTime.now()); }else {
	 * wechatUserInfo.setUpdateBy("user");
	 * wechatUserInfo.setUpdateTime(LocalDateTime.now()); }
	 * wechatUserInfoService.saveOrUpdate(wechatUserInfo,updateWrapper); return
	 * ResponseDataUtil.buildSuccess("用户信息保存成功"); } return
	 * ResponseDataUtil.buildError("数据不能为空！"); } catch (Exception e) {
	 * e.printStackTrace(); return ResponseDataUtil.buildError("用户信息保存失败"); } }
	 * 
	 * 
	 * @ApiOperation("获取微信用户信息")
	 * 
	 * @ApiImplicitParam(name = "openId", value = "微信用户信息openId", paramType ="query"
	 * , dataType = "String" ,required = true)
	 * 
	 * @GetMapping("/getWechatInfo") public Object getWechatInfo(@RequestParam()
	 * String openId) { try { WechatUserInfo wechatUserInfo =
	 * wechatUserInfoService.query().eq("OPEN_ID", openId).one(); return
	 * ResponseDataUtil.buildSuccess(wechatUserInfo); } catch (Exception e) {
	 * e.printStackTrace(); return ResponseDataUtil.buildError("获取用户信息失败"); } }
	 */
	
	public LinkedHashMap<String, String> getOpenId( String appid , String secret , String js_code ) {
		getOpenId getopenid=new getOpenId();
		//调用访问微信服务器工具方法，传入三个参数获取带有openid、session_key的json字符串
		String jsonId=getopenid.getopenid(appid,js_code,secret);
		LinkedHashMap<String, String> openIdObj= (LinkedHashMap<String, String>) JSONUtils.parse(jsonId);
		return openIdObj;
	}
	

}
