package com.colorful.nuoche.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.colorful.nuoche.dao.WechatuserinfoMapper;
import com.colorful.nuoche.entity.Wechatuserinfo;
import com.colorful.nuoche.entity.WechatuserinfoExample;


@Service
public class WechatInfoService {

	
	@Autowired
	private WechatuserinfoMapper wechatuserinfoMapper;
	
	public int registerAddOrUpdate(Wechatuserinfo wechatuserinfo ) {
		int num = 
		
		wechatuserinfoMapper.insertSelective(wechatuserinfo);
	}
}
