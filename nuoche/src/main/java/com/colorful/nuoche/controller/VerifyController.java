package com.colorful.nuoche.controller;

import java.util.concurrent.TimeUnit;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.colorful.nuoche.common.units.VerifyUtil;
import com.colorful.nuoche.compent.CodeFile;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 生成验证码
 * 
 * @author travel
 *
 */
@Api(tags = "验证码", description = "获取验证码")
@RestController
public class VerifyController {
	
	
	@Autowired
	private RedisTemplate<String, Object> redisTemplate;
	
	/**
	 * 验证码图片
	 * @param request
	 * @param response
	 */
	@ApiOperation("获取验证码")
	@GetMapping("/verifyImg")
	public void createImg(HttpServletRequest request, HttpServletResponse response) {
		response.setContentType("image/jpeg");// 设置相应类型,告诉浏览器输出的内容为图片
		response.setHeader("Pragma", "No-cache");// 设置响应头信息，告诉浏览器不要缓存此内容
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expire", 0);
		String sessionId = request.getSession().getId();
		VerifyUtil randomValidateCode = new VerifyUtil();
		String code = randomValidateCode.getRandcode(request, response);// 输出验证码图片
		// 将生成的随机验证码存放到redis中
		redisTemplate.opsForValue().set(sessionId + CodeFile.verifyCode, code,600,TimeUnit.SECONDS);
	}

}
