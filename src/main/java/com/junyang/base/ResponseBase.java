package com.junyang.base;

import lombok.Getter;
import lombok.Setter;
/**
 * 
 * @author csz
 *
 */
@Getter
@Setter
public class ResponseBase {

	private Integer rtncode;
	private String msg;
	private Object data;
	private Integer total;
	
	public ResponseBase() {
		super();
	}

	public ResponseBase(Integer rtncode, String msg, Object data, Integer total) {
		super();
		this.rtncode = rtncode;
		this.msg = msg;
		this.data = data;
		this.total = total;
	}

	

}
