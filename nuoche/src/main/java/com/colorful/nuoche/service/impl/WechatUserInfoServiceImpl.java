package com.colorful.nuoche.service.impl;

import com.colorful.nuoche.entity.WechatUserInfo;
import com.colorful.nuoche.mapper.WechatUserInfoMapper;
import com.colorful.nuoche.service.WechatUserInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

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
public class WechatUserInfoServiceImpl extends ServiceImpl<WechatUserInfoMapper, WechatUserInfo> implements WechatUserInfoService {

	@Autowired
	private WechatUserInfoMapper wechatUserInfoMapper;
}
