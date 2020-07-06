package com.colorful.nuoche.service.impl;

import com.colorful.nuoche.entity.ChepaiInfo;
import com.colorful.nuoche.mapper.ChepaiInfoMapper;
import com.colorful.nuoche.service.ChepaiInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author yangjin
 * @since 2020-06-24
 */
@Service
public class ChepaiInfoServiceImpl extends ServiceImpl<ChepaiInfoMapper, ChepaiInfo> implements ChepaiInfoService {

	@Autowired
	private ChepaiInfoMapper chepaiInfoMapper;

	@Override
	public List<ChepaiInfo> queryChepaiInfoByOpenId(String openId) {
		if(StringUtils.isNotBlank(openId)) {
			return chepaiInfoMapper.queryChepaiInfoByOpenId(openId);
		}else {
			return null;
		}
	}
	
}
