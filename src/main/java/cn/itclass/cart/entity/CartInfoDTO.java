package cn.itclass.cart.entity;

import java.io.Serializable;
import java.math.BigDecimal;

public class CartInfoDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 商品默认展示图
     */
    private String defaultPic;

    /**
     * 商品名称
     */
    private String goodsTitle;

    /**
     * 商品价格
     */
    private BigDecimal sellPrice;

    /**
     * 计价单位
     */
    private String priceUnit;

    /**
     * 商品库存
     */
    private Integer stock;

    /**
     * 该商品购买数量
     */
    private Integer count;

    public String getDefaultPic() {
        return defaultPic;
    }

    public void setDefaultPic(String defaultPic) {
        this.defaultPic = defaultPic;
    }

    public String getGoodsTitle() {
        return goodsTitle;
    }

    public void setGoodsTitle(String goodsTitle) {
        this.goodsTitle = goodsTitle;
    }

    public BigDecimal getSellPrice() {
        return sellPrice;
    }

    public void setSellPrice(BigDecimal sellPrice) {
        this.sellPrice = sellPrice;
    }

    public String getPriceUnit() {
        return priceUnit;
    }

    public void setPriceUnit(String priceUnit) {
        this.priceUnit = priceUnit;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
