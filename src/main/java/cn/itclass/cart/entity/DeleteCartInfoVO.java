package cn.itclass.cart.entity;

import cn.itclass.common.entity.BaseVO;
import io.swagger.annotations.ApiModelProperty;

public class DeleteCartInfoVO extends BaseVO {
    /**
     * 购物车id
     */
    @ApiModelProperty(value = "cartId", name = "购物车id")
    private String cartId;

    public String getCartId() {
        return cartId;
    }

    public void setCartId(String cartId) {
        this.cartId = cartId;
    }
}
