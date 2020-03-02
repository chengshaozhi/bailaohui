package com.junyang.entity;
import lombok.Getter;
import lombok.Setter;
/**
 * @category 回复图文
 * @author csz
 *
 */
@Getter
@Setter
public class ReplyImageTextEntity {

	private Integer id;//主键
	
	private String title;//标题
	
	private String notes;//描述
	
	private String url;//链接地址
	
	private Integer imgtype;//图片类型1,单图，2多图
	
	private Integer online;//是否上线

	public ReplyImageTextEntity() {
		super();
	}

	public ReplyImageTextEntity(Integer id, String title, String notes, String url, Integer imgtype, Integer online) {
		super();
		this.id = id;
		this.title = title;
		this.notes = notes;
		this.url = url;
		this.imgtype = imgtype;
		this.online = online;
	}
	
	
	
	

}
