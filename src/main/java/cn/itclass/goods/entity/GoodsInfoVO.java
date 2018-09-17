package cn.itclass.goods.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.models.auth.In;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;

/**
 *
 * @author Yi Chen
 *
 */

@ApiModel(value = "GoodsInfoVO", description = "商品信息VO")
public class GoodsInfoVO {

    /**
     * 商品名称
     */
    @NotBlank(message = "商品名称不能为空")
    @ApiModelProperty(value = "goodsTitle", name = "商品名称")
    private String goodsTitle;

    /**
     * 商品默认图片
     */
    @NotBlank(message = "默认图片不能为空")
    @ApiModelProperty(value = "defaultPic", name = "商品默认图片")
    private String defaultPic;

    /**
     * 商品展示图片1
     */
    @NotBlank(message = "商品展示图片1不能为空")
    @ApiModelProperty(value = "displayPic1", name = "商品展示图片1")
    private String displayPic1;

    /**
     * 商品展示图片2
     */
    @NotBlank(message = "商品展示图片2不能为空")
    @ApiModelProperty(value = "displayPic2", name = "商品展示图片2")
    private String displayPic2;

    /**
     * 商品售价
     */
    @NotBlank(message = "商品售价不能为空")
    @ApiModelProperty(value = "sellPrice", name = "商品售价")
    private BigDecimal sellPrice;

    /**
     * 商品折扣方式id
     */
    @NotBlank(message = "商品折扣方式id不能为空")
    @ApiModelProperty(value = "discountId", name = "商品折扣方式id")
    private Integer discountId;

    /**
     * 商品折扣
     */
    @NotBlank(message = "商品折扣不能为空")
    @ApiModelProperty(value = "discount", name = "商品折扣")
    private Double discount;

    /**
     * 计价单位
     */
    @NotBlank(message = "计价单位不能为空")
    @ApiModelProperty(value = "priceUnit", name = "计价单位")
    private String priceUnit;

    /**
     * 商品简述
     */
    @NotBlank(message = "商品简述不能为空")
    @ApiModelProperty(value = "goodsAbstract", name = "商品简述")
    private String goodsAbstract;

    /**
     * 商品详细描述
     */
    @NotBlank(message = "商品详细描述不能为空")
    @ApiModelProperty(value = "detailContent", name = "商品详细描述")
    private String detailContent;

    /**
     * 商品库存
     */
    @NotBlank(message = "商品库存不能为空")
    @ApiModelProperty(value = "stock", name = "商品库存")
    private Integer stock;

    /**
     * 商品类型
     */
    @NotBlank(message = "商品类型不能为空")
    @ApiModelProperty(value = "type", name = "商品类型")
    private String type;

    public String getGoodsTitle() {
        return goodsTitle;
    }

    public void setGoodsTitle(String goodsTitle) {
        this.goodsTitle = goodsTitle;
    }

    public String getDefaultPic() {
        return defaultPic;
    }

    public void setDefaultPic(String defaultPic) {
        this.defaultPic = defaultPic;
    }

    public String getDisplayPic1() {
        return displayPic1;
    }

    public void setDisplayPic1(String displayPic1) {
        this.displayPic1 = displayPic1;
    }

    public String getDisplayPic2() {
        return displayPic2;
    }

    public void setDisplayPic2(String displayPic2) {
        this.displayPic2 = displayPic2;
    }

    public BigDecimal getSellPrice() {
        return sellPrice;
    }

    public void setSellPrice(BigDecimal sellPrice) {
        this.sellPrice = sellPrice;
    }

    public Integer getDiscountId() {
        return discountId;
    }

    public void setDiscountId(Integer discountId) {
        this.discountId = discountId;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    public String getPriceUnit() {
        return priceUnit;
    }

    public void setPriceUnit(String priceUnit) {
        this.priceUnit = priceUnit;
    }

    public String getGoodsAbstract() {
        return goodsAbstract;
    }

    public void setGoodsAbstract(String goodsAbstract) {
        this.goodsAbstract = goodsAbstract;
    }

    public String getDetailContent() {
        return detailContent;
    }

    public void setDetailContent(String detailContent) {
        this.detailContent = detailContent;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
