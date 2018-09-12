package cn.itclass.user.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.Valid;

@ApiModel(value = "UserVo", description = "用户Vo")
public class UserVo {

	/**
	 * 账号名
	 */
	@NotBlank(message = "账号不能为空")
	@ApiModelProperty(value = "userAccount", name = "账户名")
	private String userAccount;

	/**
	 * 账户密码
	 */
	@NotBlank(message = "密码不能为空")
	@ApiModelProperty(value = "password", name = "密码")
	private String password;

	/**
	 * 注册手机号
	 */
	@NotBlank(message = "手机号不能为空")
	@ApiModelProperty(value = "phoneNumber", name = "手机号")
	private String phoneNumber;

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
}
