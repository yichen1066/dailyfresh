package cn.itclass.user.entity;

import cn.itclass.common.entity.BaseVO;
import io.swagger.annotations.ApiModel;

import javax.validation.constraints.NotNull;

@ApiModel(value = "AddAddressVO", description = "添加收货地址VO")
public class AddAddressVO extends BaseVO{

    @NotNull(message = "地址对象不能为空")
    private AddressPOJO address;

    public AddressPOJO getAddress() {
        return address;
    }

    public void setAddress(AddressPOJO address) {
        this.address = address;
    }
}
