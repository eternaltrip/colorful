package com.colorful.nuoche.controller;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.colorful.nuoche.entity.ChepaiInfo;
import com.colorful.nuoche.entity.common.ResponseMap;
import com.colorful.nuoche.service.ChepaiInfoService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;

@Api(tags="车牌登记" , description = "车牌登记相关接口")
@RestController
@RequestMapping(value = "/chepai")
public class ChepaiInfoController {
	
	
	@Autowired
	private ChepaiInfoService chepaiInfoService;
	
	
	
	@ApiOperation("车牌登记")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "code1", value = "车牌所属省份", paramType = "query",  dataType = "String" ,required = true),
		@ApiImplicitParam(name = "code2", value = "车牌所属区域", paramType = "query",  dataType = "String",required = true),
		@ApiImplicitParam(name = "code3", value = "车牌编码", paramType = "query",  dataType = "String",required = true),
		@ApiImplicitParam(name = "contactNum", value = "联系电话", paramType = "query",  dataType = "String",required = true),
		@ApiImplicitParam(name = "nick", value = "称呼", paramType = "query",  dataType = "String",required = true),
		@ApiImplicitParam(name = "wechatUserInfoId", value = "微信用户在本系统的唯一id，由服务器返回", paramType = "query",  dataType = "String",required = true),
		@ApiImplicitParam(name = "chepaiId", value = "该车牌已登记的id,已有则需要传，否则不需要", paramType = "query",  dataType = "String",required = false)
	})
	@ResponseBody
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public Object register(@RequestParam(name="code1" ,required = true) String code1,
							@RequestParam(name="code2" ,required = true) String code2,
							@RequestParam(name="code3" ,required = true) String code3,
							@RequestParam(name="contactNum" ,required = true) String contactNum,
							@RequestParam(name="nick" ,required = true) String nick,
							@RequestParam(name="wechatUserInfoId" ,required = true) String wechatUserInfoId,
							String chepaiId) {
		ResponseMap retVal = new ResponseMap();
		retVal.setCode(400);
		
		Map<String,Object> chePaiCodes = new ChePaiCodeController().getChePaiCodes();
		String[] areaArr = (String[]) chePaiCodes.get(code1);
		
		if(areaArr !=null && areaArr.length > 0 ) {
			int num = Arrays.binarySearch(areaArr, code2);
			if(num >= 0 ) {
				ChepaiInfo chepaiInfo = new ChepaiInfo();
				if(StringUtils.isBlank(chepaiId)) {
					chepaiInfo.setId(UUID.randomUUID().toString());
					chepaiInfo.setCreateTime(LocalDateTime.now());
					chepaiInfo.setCreateBy("user");
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
				retVal.setCode(200);
				retVal.setMsg("登记完成");
			}else {
				retVal.setMsg("请输入正确的车牌所属区域");
			}
		}else {
			retVal.setMsg("请输入正确的车牌所属省份");
		}
		return retVal;
	}

}
