package com.junyang.entity;
import java.util.Date;
import lombok.Getter;
import lombok.Setter;

/**
 * @category 微信账号
 * @author csz
 *
 */

@Getter
@Setter
public class WeChatAcctiveEntity {

	private Integer id;//主键
	
	private String nickname;//昵称
	
	private String sex;//性别
	
	private String openid;//微信openid
	
	private  String unionid;//微信unionid
	
	private String language;//语言
	
	private Date setdate;//创建时间
	
	private Integer attention;//是否关注 0false,1true
	
	private Date attentiondate;//关注时间
	
	private Date offattentiondate;//取消关注时间
	
	private String city;//所属市
	
	private String province;//所属省
	
	private String nation;//所属国
	
	private String photo;//头像
	
	private Integer admin;//是否管理员0false,1true
	
	private Integer wechatuid;//微信用户id

	public WeChatAcctiveEntity() {
		super();
	}

	public WeChatAcctiveEntity(Integer id, String nickname, String sex, String openid, String unionid, String language,
			Date setdate, Integer attention, Date attentiondate, Date offattentiondate, String city, String province,
			String nation, String photo, Integer admin, Integer wechatuid) {
		super();
		this.id = id;
		this.nickname = nickname;
		this.sex = sex;
		this.openid = openid;
		this.unionid = unionid;
		this.language = language;
		this.setdate = setdate;
		this.attention = attention;
		this.attentiondate = attentiondate;
		this.offattentiondate = offattentiondate;
		this.city = city;
		this.province = province;
		this.nation = nation;
		this.photo = photo;
		this.admin = admin;
		this.wechatuid = wechatuid;
	}

	


	
	
	
	
	

}
