package com.colorful.nuoche.service;

import com.colorful.nuoche.entity.ChepaiInfo;

import java.util.List;

import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author yangjin
 * @since 2020-06-24
 */
public interface ChepaiInfoService extends IService<ChepaiInfo> {

	List<ChepaiInfo> queryChepaiInfoByOpenId(String openId);

}
