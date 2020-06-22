package com.colorful.nuoche.entity;

import java.util.Date;

/**
 * 车牌信息
 * @author travel
 *
 */
public class ChePai {
	
	
	private String id;
	
	
	private String chePai;
	
	
	private String contactNum;
	
	
	private String contactPersonName;
	
	private Date createTime;
	
	private Date updateTime;
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getChePai() {
		return chePai;
	}
	public void setChePai(String chePai) {
		this.chePai = chePai;
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
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	
	
}
