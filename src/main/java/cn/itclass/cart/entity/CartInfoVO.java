package cn.itclass.cart.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;

@ApiModel(value = "CartInfoVO", description = "购物车Vo")
public class CartInfoVO {

    /**
     * 每一条购物车记录的购物数量
     */
    @NotNull(message = "购物车记录数量不能为空")
    @ApiModelProperty(value = "count", name = "购物车商品数量")
    private Integer count;

    /**
     * 商品id
     */
    @NotNull(message = "商品id不能为空")
    @ApiModelProperty(value = "goodsId", name = "商品id")
    private String goodsId;

    /**
     * 用户id
     */
    @NotNull(message = "用户id不能为空")
    @ApiModelProperty(value = "userId", name = "用户id")
    private String userId;

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
