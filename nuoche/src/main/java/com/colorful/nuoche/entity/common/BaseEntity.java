package com.colorful.nuoche.entity.common;

import java.time.LocalDateTime;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;

import io.swagger.annotations.ApiModel;


/*
 * 实体共有属性
 * 
 */
@ApiModel(value = "实体共有属性", description = "")
public class BaseEntity {

	@TableId("ID")
	private String id;
	
	@TableField("CREATE_TIME")
	private LocalDateTime createTime;

	@TableField("UPDATE_TIME")
	private LocalDateTime updateTime;
	
	@TableField("CREATE_BY")
	private String createBy;

	@TableField("UPDATE_BY")
	private String updateBy;
	
	
	public static final String CREATE_TIME = "CREATE_TIME";

	public static final String UPDATE_TIME = "UPDATE_TIME";
	
	public static final String CREATE_BY = "CREATE_BY";
	
	public static final String UPDATE_BY = "UPDATE_BY";

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public LocalDateTime getCreateTime() {
		return createTime;
	}

	public void setCreateTime(LocalDateTime createTime) {
		this.createTime = createTime;
	}

	public LocalDateTime getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(LocalDateTime updateTime) {
		this.updateTime = updateTime;
	}

	public String getCreateBy() {
		return createBy;
	}

	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

	public String getUpdateBy() {
		return updateBy;
	}

	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
	}
	
	
}
