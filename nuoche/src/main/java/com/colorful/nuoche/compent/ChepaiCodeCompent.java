package com.colorful.nuoche.compent;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import com.colorful.nuoche.common.units.TextFilesReader;

@Component
public class ChepaiCodeCompent {
	
	@Autowired
	private RedisTemplate<String, Object> redisTemplate;

	/**
	 * 车牌所属区域code
	 */
	@SuppressWarnings("unchecked")
	public Map<String, Object> getChepaiCode() {
		String chepaiCodeFileName = CodeFile.chepaiCodeFileName;
		String chePaiCacheKey = CodeFile.chePaiCacheKey;
		
		Map<String, Object> chePaiCodes = (Map<String, Object>) redisTemplate.opsForValue().get(chePaiCacheKey);
		if (chePaiCodes == null) {
			synchronized (this) {
				chePaiCodes = (Map<String, Object>) redisTemplate.opsForValue().get(chePaiCacheKey);
				if (chePaiCodes == null) {
					List<String> lines = TextFilesReader.read(chepaiCodeFileName);
					chePaiCodes = new HashMap<>();
					for (String line : lines) {
						String text = line.substring(0, 1);
						String[] areaArr = line.substring(1, line.length()).split("-");
						chePaiCodes.put(text, areaArr);
					}
					System.out.println("数据放入redis");
					redisTemplate.opsForValue().set(chePaiCacheKey, chePaiCodes);
				}
			}
		}
		return chePaiCodes;
	}


}
