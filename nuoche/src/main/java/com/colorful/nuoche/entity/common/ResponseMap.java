package com.colorful.nuoche.entity.common;



/**
 * 返回对象
 * @author travel
 *
 */
public class ResponseMap {
	private int code;
	private String msg;
	private Object Data;
	
	public ResponseMap() {
		super();
	}
	public ResponseMap(int code, String msg, Object data) {
		super();
		this.code = code;
		this.msg = msg;
		Data = data;
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
	public Object getData() {
		return Data;
	}
	public void setData(Object data) {
		Data = data;
	}
	
	
}
