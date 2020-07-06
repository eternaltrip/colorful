package com.colorful.nuoche.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.colorful.nuoche.entity.common.BaseEntity;

import io.swagger.annotations.ApiModel;

/**
 * @author yangjin
 * @since 2020-06-24
 */
@ApiModel(value = "WechatUserInfo对象", description = "")
@TableName("WECHAT_USER_INFO")
public class WechatUserInfo extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@TableField("OPEN_ID")
	private String openId;

	@TableField("NICK_NAME")
	private String nickName;

	@TableField("GENDER")
	private String gender;

	@TableField("CITY")
	private String city;

	@TableField("PROVINCE")
	private String province;

	@TableField("COUNTRY")
	private String country;

	@TableField("AVATARUR1")
	private String avatarur1;

	@TableField("UNION_ID")
	private String unionId;

	@TableField("WATER_MARK")
	private String waterMark;

	@TableField("APP_ID")
	private String appId;


	public static final String OPEN_ID = "OPEN_ID";

	public static final String NICK_NAME = "NICK_NAME";

	public static final String GENDER = "GENDER";

	public static final String CITY = "CITY";

	public static final String PROVINCE = "PROVINCE";

	public static final String COUNTRY = "COUNTRY";

	public static final String AVATARUR1 = "AVATARUR1";

	public static final String UNION_ID = "UNION_ID";

	public static final String WATER_MARK = "WATER_MARK";

	public static final String APP_ID = "APP_ID";

	public String getOpenId() {
		return openId;
	}

	public void setOpenId(String openId) {
		this.openId = openId;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getAvatarur1() {
		return avatarur1;
	}

	public void setAvatarur1(String avatarur1) {
		this.avatarur1 = avatarur1;
	}

	public String getUnionId() {
		return unionId;
	}

	public void setUnionId(String unionId) {
		this.unionId = unionId;
	}

	public String getWaterMark() {
		return waterMark;
	}

	public void setWaterMark(String waterMark) {
		this.waterMark = waterMark;
	}

	public String getAppId() {
		return appId;
	}

	public void setAppId(String appId) {
		this.appId = appId;
	}



}
