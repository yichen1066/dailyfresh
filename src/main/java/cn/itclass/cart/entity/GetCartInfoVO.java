package cn.itclass.cart.entity;

import cn.itclass.common.entity.BaseVO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;

import java.util.List;

@ApiModel(value = "获取订单信息VO")
public class GetCartInfoVO extends BaseVO {
    @ApiModelProperty(value = "cartId", name = "cartId集合")
    List<String> cartIds;

    public List<String> getCartIds() {
        return cartIds;
    }

    public void setCartIds(List<String> cartIds) {
        this.cartIds = cartIds;
    }
}
