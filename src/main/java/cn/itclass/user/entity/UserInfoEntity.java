package cn.itclass.user.entity;

import cn.itclass.common.entity.BaseEntity;

import javax.persistence.*;
import java.util.Date;

/**
 * 用户信息表
 * 
 * @author Yi Chen
 *
 */

@Entity
@Table(name="df_user")
public class UserInfoEntity extends BaseEntity {
	
	private static final long serialVersionUID = 1L;

	/**
	 * 用户id，主键
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="user_id")
	private Long id;

	/**
	 * 账号名
	 */
	@Column(name="user_account",nullable = false)
	private String userAccount;

	/**
	 * 账户密码
	 */
	@Column(nullable = false)
	private String password;

	/**
	 * 注册手机号
	 */
	@Column(name="phone_number",nullable = false)
	private String phoneNumber;

	/**
	 * 默认的收货地址id
	 */
	@Column(name="default_address_id",nullable = false)
	private Integer defaultAddressId = 0;

	/**
	 * 注册时间
	 */
	@Column(name="registration_time",nullable = false)
	private Date registrationTime;

	/**
	 * 登录时间
	 */
	@Column(name="login_time")
	private Date loginTime;

	/**
	 * 头像
	 */
	private String avatar;

	/**
	 * 昵称
	 */
	@Column(name = "nick_name")
	private String nickName;

	/**
	 * 真实姓名
	 */
	@Column(name = "real_name")
	private String realName;

	/**
	 * 出生年月日
	 */
	@Temporal(TemporalType.DATE)
	@Column(length = 10)
	private Date birthdate;

	/**
	 * 居住地址
	 */
	private String residence;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserAccount() {
		return userAccount;
	}

	public void setUserAccount(String userAccount) {
		this.userAccount = userAccount;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Integer getDefaultAddressId() {
		return defaultAddressId;
	}

	public void setDefaultAddressId(Integer defaultAddressId) {
		this.defaultAddressId = defaultAddressId;
	}

	public Date getRegistrationTime() {
		return registrationTime;
	}

	public void setRegistrationTime(Date registrationTime) {
		this.registrationTime = registrationTime;
	}

	public Date getLoginTime() {
		return loginTime;
	}

	public void setLoginTime(Date loginTime) {
		this.loginTime = loginTime;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public Date getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}

	public String getResidence() {
		return residence;
	}

	public void setResidence(String residence) {
		this.residence = residence;
	}
}
