package com.colorful.nuoche.entity.common;



/**
 * 返回对象
 * @author travel
 *
 */
public class ResponseMap {
	private int code;
	private String msg;
	
	public ResponseMap() {
		super();
	}
	public ResponseMap(int code, String msg) {
		super();
		this.code = code;
		this.msg = msg;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	
}
