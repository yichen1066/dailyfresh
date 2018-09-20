package cn.itclass.common.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

public class BaseVO {

    @ApiModelProperty(value = "userId", name = "用户id")
    private String userId;

    public String getUser_id() {
        return userId;
    }

    public void setUser_id(String userId) {
        this.userId = userId;
    }
}
