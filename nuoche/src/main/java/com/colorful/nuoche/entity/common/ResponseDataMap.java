package com.colorful.nuoche.entity.common;



/**
 * 返回对象
 * @author travel
 *
 */
public class ResponseDataMap extends ResponseMap {
	private Object Data;
	
	public ResponseDataMap() {
		super();
	}
	


	public ResponseDataMap(int code, String msg , Object Data) {
		super(code, msg);
		this.Data = Data;
	}



	public Object getData() {
		return Data;
	}
	public void setData(Object data) {
		Data = data;
	}
	
	
}
