package com.colorful.nuoche.controller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.colorful.nuoche.entity.common.ResponseMap;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;

@Api(tags="车牌登记" , description = "车牌登记相关接口")
@RestController
@RequestMapping(value = "/chepai")
public class ChePaiRegisterController {
	
	
	
	@ApiOperation("车牌登记")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "code1", value = "车牌所属省份", paramType = "query",  dataType = "String"),
		@ApiImplicitParam(name = "code2", value = "车牌所属区域", paramType = "query",  dataType = "String"),
		@ApiImplicitParam(name = "code3", value = "车牌编码", paramType = "query",  dataType = "String"),
		@ApiImplicitParam(name = "contactNum", value = "联系电话", paramType = "query",  dataType = "String"),
		@ApiImplicitParam(name = "nick", value = "称呼", paramType = "query",  dataType = "String")
	})
	@ResponseBody
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public Object register(@RequestParam(name="code1" ,required = true) String code1,
							@RequestParam(name="code2" ,required = true) String code2,
							@RequestParam(name="code3" ,required = true) String code3,
							@RequestParam(name="contactNum" ,required = true) String contactNum,
							@RequestParam(name="nick" ,required = true) String nick) {
		ResponseMap retVal = new ResponseMap();
		retVal.setCode(400);
		
		Map<String,Object> chePaiCodes = new ChePaiCodeController().getChePaiCodes();
		String[] areaArr = (String[]) chePaiCodes.get(code1);
		
		if(areaArr !=null && areaArr.length > 0 ) {
			int num = Arrays.binarySearch(areaArr, code2);
			if(num >= 0 ) {
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
