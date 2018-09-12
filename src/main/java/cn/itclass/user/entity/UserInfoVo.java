package cn.itclass.user.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Column;
import java.util.Date;

@ApiModel(value = "UserInfoVo", description = "用户信息Vo")
public class UserInfoVo {

    /**
     * 昵称
     */
    @ApiModelProperty(value = "nickName", name = "昵称")
    private String nickName;

    /**
     * 真实姓名
     */
    @ApiModelProperty(value = "realName", name = "真实姓名")
    private String realName;

    /**
     * 出生年月日
     */
    @ApiModelProperty(value = "birthdate", name = "出生年月日")
    private Date birthdate;

    /**
     * 居住地址
     */
    @ApiModelProperty(value = "residence", name = "居住地址")
    private String residence;

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
