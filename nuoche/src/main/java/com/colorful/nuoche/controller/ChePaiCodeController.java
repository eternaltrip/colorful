package com.colorful.nuoche.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.colorful.nuoche.entity.common.ResponseDataMap;
import com.colorful.nuoche.entity.common.ResponseMap;
import com.colorful.nuoche.units.ResourceFilesReader;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;

@Api(tags = "车牌区域代码", description = "车牌区域代码相关接口")
@RestController
@RequestMapping(value = "/code")
public class ChePaiCodeController {
	// 车牌代码文件
	private static String chepaiCodeFileName = "properties/chepaiCode.txt";
	
	//车牌代码缓存集合
	private static Map<String,Object> chePaiCodes;

	
	
	
	/**
	 * 获取车牌区域代码
	 * @return
	 */
	public  Map<String, Object> getChePaiCodes() {
		if (chePaiCodes == null) {
			synchronized (this) {
				if (chePaiCodes == null) {
					List<String> lines = ResourceFilesReader.read(chepaiCodeFileName);
					chePaiCodes = new HashMap<>();
					lines.forEach(line -> {
						String text = line.substring(0, 1);
						String[] areaArr = line.substring(1, line.length()).split("-");
						chePaiCodes.put(text, areaArr);
					});
				}
			}
		}
		return chePaiCodes;
	}





	@ApiOperation("获取车牌区域代码")
	@ResponseBody
	@RequestMapping(value = "/chePaiCode", method = RequestMethod.GET)
	public Object code() throws IOException {
		return new ResponseDataMap(200,"请求成功",getChePaiCodes());
	}

}
