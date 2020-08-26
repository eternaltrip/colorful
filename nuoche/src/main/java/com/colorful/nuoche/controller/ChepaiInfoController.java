package com.colorful.nuoche.controller;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.collections4.map.HashedMap;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.colorful.nuoche.compent.ChepaiCodeCompent;
import com.colorful.nuoche.compent.CodeFile;
import com.colorful.nuoche.entity.ChepaiInfo;
import com.colorful.nuoche.entity.WechatUserInfo;
import com.colorful.nuoche.entity.common.ResponseData;
import com.colorful.nuoche.entity.common.ResponseDataUtil;
import com.colorful.nuoche.entity.common.ResultEnums;
import com.colorful.nuoche.service.ChepaiInfoService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@Api(tags="车牌信息" , description = "车牌信息相关接口")
@RestController
@RequestMapping(value = "/chepai")
public class ChepaiInfoController {
	
	@Autowired
	private RedisTemplate<String, Object> redisTemplate;

	@Autowired
	private ChepaiInfoService chepaiInfoService;

	@Autowired
	private ChepaiCodeCompent chepaiCodeCompent;
	
	
	@SuppressWarnings("unchecked")
	@ApiOperation("车牌登记")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "code1", value = "车牌所属省份", paramType = "query",  dataType = "String" ,required = true),
		@ApiImplicitParam(name = "code2", value = "车牌所属区域", paramType = "query",  dataType = "String",required = true),
		@ApiImplicitParam(name = "code3", value = "车牌编码", paramType = "query",  dataType = "String",required = true),
		@ApiImplicitParam(name = "contactNum", value = "联系电话", paramType = "query",  dataType = "String",required = true),
		@ApiImplicitParam(name = "nick", value = "称呼", paramType = "query",  dataType = "String",required = true),
		@ApiImplicitParam(name = "wechatUserInfoId", value = "微信用户在本系统的唯一id，由服务器返回", paramType = "query",  dataType = "String",required = true),
		@ApiImplicitParam(name = "verifyCode", value = "验证码", paramType = "query",  dataType = "String",required = true),
		@ApiImplicitParam(name = "chepaiId", value = "该车牌已登记的id,已有则需要传，否则不需要", paramType = "query",  dataType = "String",required = false)
	})
	@RequestMapping(value = "/bind", method = RequestMethod.POST)
	public Object register(HttpServletRequest request ,
							@RequestParam(name="code1" ,required = true) String code1,
							@RequestParam(name="code2" ,required = true) String code2,
							@RequestParam(name="code3" ,required = true) String code3,
							@RequestParam(name="contactNum" ,required = true) String contactNum,
							@RequestParam(name="nick" ,required = true) String nick,
							@RequestParam(name="wechatUserOpenId" ,required = true) String wechatUserInfoId,
							@RequestParam(name="verifyCode" ,required = true) String verifyCode,
							String chepaiId) {
		ResponseData<Object> responseData = null; 
		if(request != null && request.getSession() != null) {
			String sessionIdKey = request.getSession().getId() + CodeFile.verifyCode;
			
			String verifyCodeInCache = (String)redisTemplate.opsForValue().get(sessionIdKey);
			
			//验证码是否正确
			if(verifyCode.equalsIgnoreCase(verifyCodeInCache)) {
				//如果正确就删除key，下次使用时，重新获取
				redisTemplate.delete(sessionIdKey);
				
				Map<String,Object> chePaiCodes = chepaiCodeCompent.getChepaiCode();
				String[] areaArr = (String[]) chePaiCodes.get(code1);
				
				if(areaArr !=null && areaArr.length > 0 ) {
					int num = Arrays.binarySearch(areaArr, code2);
					if(num >= 0 ) {
						ChepaiInfo chepaiInfo = new ChepaiInfo();
						if(StringUtils.isBlank(chepaiId)) {
							int carsNO = chepaiInfoService.query().eq("WECHAT_USER_INFO_ID", wechatUserInfoId).count();
							if(carsNO > 9) {
								responseData = ResponseDataUtil.buildError(ResultEnums.ERROR.getCode(),"您绑定的车辆不能超过10辆");
							}else {
								chepaiInfo.setId(UUID.randomUUID().toString());
								chepaiInfo.setCreateTime(LocalDateTime.now());
								chepaiInfo.setCreateBy("user");
							}
						}else {
							chepaiInfo.setId(chepaiId);
							chepaiInfo.setUpdateTime(LocalDateTime.now());
							chepaiInfo.setUpdateBy("user");
						}
						chepaiInfo.setChepai(code1+code2+code3);
						chepaiInfo.setContactNum(contactNum);
						chepaiInfo.setContactPersonName(nick);
						chepaiInfo.setWechatUserInfoId(wechatUserInfoId);
						chepaiInfoService.saveOrUpdate(chepaiInfo);
						responseData = ResponseDataUtil.buildSuccess("登记完成");
					}else {
						responseData = ResponseDataUtil.buildError(ResultEnums.PARAM_ERROR.getCode(),"请输入正确的车牌所属区域");
					}
				}else {
					responseData = ResponseDataUtil.buildError(ResultEnums.PARAM_ERROR.getCode(),"请输入正确的车牌所属省份");
				}
			}else {
				responseData = ResponseDataUtil.buildError(ResultEnums.VERIFY_CODE_ERROR.getCode(),"验证码错误,请刷新验证码");
			}
		}else {
			responseData = ResponseDataUtil.buildError(ResultEnums.ERROR);
		}
		return responseData;
	}
	
	
	
	@ApiOperation("获取绑定车牌信息")
	@ApiImplicitParam(name = "openId", value = "微信用户信息openId", paramType ="query" ,  dataType = "String" ,required = true)
	@GetMapping("/getChePaiInfo")
	public Object getChePaiInfo(@RequestParam() String openId) {
		try {
			List<ChepaiInfo> chepaiInfos = chepaiInfoService.queryChepaiInfoByOpenId(openId);
			return ResponseDataUtil.buildSuccess(chepaiInfos);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseDataUtil.buildError("获取绑定车牌信息失败");
		}
	}
}
