package com.junyang.entity;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

/**
 * @category 内容
 * @author csz
 *
 */

@Getter
@Setter
public class ContentEntity {

	private Integer id;//主键
	
	private String title;//标题
	
	private String type;//类型
	
	private String label;//标签
	
	private Integer power;//浏览权限
	
	private String code;//审核编码
	
	private Date expiretime;//到期日
	
	private Date publishtime;//发布时间
	
	private String cover;//封面
	
	private String notes;//描述
	
	private Integer tweet;//关联推文
	
	private String link;//外部链接
	
	private String content;//内容
	
	private Integer state;//上线状态
	
	private String adjunct;//附件url地址
	
	private Integer share;//可否分享
	
	private Date Createdtime;//创建时间
	
	private Date updatetime;//更新时间

	public ContentEntity() {
		super();
	}

	public ContentEntity(Integer id, String title, String type, String label, Integer power, String code,
			Date expiretime, Date publishtime, String cover, String notes, Integer tweet, String link, String content,
			Integer state, String adjunct, Integer share, Date createdtime, Date updatetime) {
		super();
		this.id = id;
		this.title = title;
		this.type = type;
		this.label = label;
		this.power = power;
		this.code = code;
		this.expiretime = expiretime;
		this.publishtime = publishtime;
		this.cover = cover;
		this.notes = notes;
		this.tweet = tweet;
		this.link = link;
		this.content = content;
		this.state = state;
		this.adjunct = adjunct;
		this.share = share;
		Createdtime = createdtime;
		this.updatetime = updatetime;
	}
	
	
	
	
	
	
	
	
	
	

}
