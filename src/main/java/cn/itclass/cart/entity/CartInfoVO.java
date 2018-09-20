package cn.itclass.cart.entity;

import cn.itclass.common.entity.BaseVO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;

@ApiModel(value = "CartInfoVO", description = "购物车Vo")
public class CartInfoVO extends BaseVO {

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
}
