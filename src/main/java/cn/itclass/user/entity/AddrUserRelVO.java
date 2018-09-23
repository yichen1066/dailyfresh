package cn.itclass.user.entity;

import cn.itclass.common.entity.BaseVO;

import javax.validation.constraints.NotBlank;

public class AddrUserRelVO extends BaseVO {

    @NotBlank(message = "收货地址表id不能为空")
    private String addressId;

    public String getAddressId() {
        return addressId;
    }

    public void setAddressId(String addressId) {
        this.addressId = addressId;
    }
}
