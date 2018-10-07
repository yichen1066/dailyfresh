package cn.itclass.order.model.vo;

import cn.itclass.common.entity.BaseVO;
import io.swagger.annotations.ApiModel;

import javax.persistence.Column;
import java.math.BigDecimal;
import java.util.List;

@ApiModel(value = "PlaceOrderVO", description = "下单VO")
public class PlaceOrderVO extends BaseVO {

    /**
     * 购物车id
     */
    List<String> cartIds;

    /**
     * 地址id
     */
    private String addressId;

    /**
     * 是否开发票
     */
    private Boolean invoiceOrNot;

    /**
     * 支付方式
     */
    private String payChannel;

    public String getAddressId() {
        return addressId;
    }

    public void setAddressId(String addressId) {
        this.addressId = addressId;
    }

    public Boolean getInvoiceOrNot() {
        return invoiceOrNot;
    }

    public void setInvoiceOrNot(Boolean invoiceOrNot) {
        this.invoiceOrNot = invoiceOrNot;
    }

    public String getPayChannel() {
        return payChannel;
    }

    public void setPayChannel(String payChannel) {
        this.payChannel = payChannel;
    }

    public List<String> getCartIds() {
        return cartIds;
    }

    public void setCartIds(List<String> cartIds) {
        this.cartIds = cartIds;
    }
}
