package com.colorful.nuoche.mapper;

import com.colorful.nuoche.entity.ChepaiInfo;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * @author yangjin
 * @since 2020-06-24
 */
@Repository
public interface ChepaiInfoMapper extends BaseMapper<ChepaiInfo> {

	List<ChepaiInfo> queryChepaiInfoByOpenId(String openId);

}
