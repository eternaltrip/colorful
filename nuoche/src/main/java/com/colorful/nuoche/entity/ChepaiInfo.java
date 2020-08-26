package com.colorful.nuoche.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.colorful.nuoche.entity.common.BaseEntity;

import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author yangjin
 * @since 2020-06-24
 */
@ApiModel(value = "ChepaiInfo对象", description = "")
@TableName("CHEPAI_INFO")
public class ChepaiInfo extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "车牌")
	@TableField("CHEPAI")
	private String chepai;

	@ApiModelProperty(value = "联系电话")
	@TableField("CONTACT_NUM")
	private String contactNum;

	@ApiModelProperty(value = "联系人姓名")
	@TableField("CONTACT_PERSON_NAME")
	private String contactPersonName;

	
	@ApiModelProperty(value = "车主的微信OpenId")
	@TableField("WECHAT_USER_INFO_ID")
	private String wechatUserInfoId;

	
	

	public static final String CHEPAI = "CHEPAI";

	public static final String CONTACT_NUM = "CONTACT_NUM";

	public static final String CONTACT_PERSON_NAME = "CONTACT_PERSON_NAME";
	
	
	public static final String WECHAT_USER_INFO_ID = "WECHAT_USER_INFO_ID";

	public String getChepai() {
		return chepai;
	}

	public void setChepai(String chepai) {
		this.chepai = chepai;
	}

	public String getContactNum() {
		return contactNum;
	}

	public void setContactNum(String contactNum) {
		this.contactNum = contactNum;
	}

	public String getContactPersonName() {
		return contactPersonName;
	}

	public void setContactPersonName(String contactPersonName) {
		this.contactPersonName = contactPersonName;
	}

	public String getWechatUserInfoId() {
		return wechatUserInfoId;
	}

	public void setWechatUserInfoId(String wechatUserInfoId) {
		this.wechatUserInfoId = wechatUserInfoId;
	}



}
