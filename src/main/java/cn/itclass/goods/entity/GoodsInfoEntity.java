package cn.itclass.goods.entity;

import cn.itclass.common.entity.BaseEntity;
import cn.itclass.user.entity.UserInfoEntity;
import org.hibernate.mapping.Join;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name="df_goods")
public class GoodsInfoEntity extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 商品id，主键
     */
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="goods_id")
    private Long goodsId;

    /**
     * 商品名称
     */
    @Column(name="goods_title",nullable = false)
    private String goodsTitle;

    /**
     * 商品默认图片
     */
    @Column(name = "default_pic", nullable = false)
    private String defaultPic;

    /**
     * 商品展示图片1
     */
    @Column(name = "display_pic1", nullable = false)
    private String displayPic1;

    /**
     * 商品展示图片2
     */
    @Column(name = "display_pic2", nullable = false)
    private String displayPic2;

    /**
     * 商品售价
     */
    @Column(name = "sell_price", nullable = false)
    private BigDecimal sellPrice;

    /**
     * 商品折扣方式id
     */
    @Column(name = "discount_id", nullable = false)
    private Integer discountId;

    /**
     * 商品折扣
     */
    @Column(name = "discount", nullable = false)
    private Double discount;

    /**
     * 计价单位
     */
    @Column(name = "price_unit", nullable = false)
    private String priceUnit;

    /**
     * 商品点击量
     */
    @Column(name = "click_num", nullable = false)
    private Long clickNum = 0l;

    /**
     * 商品简述
     */
    @Column(name = "abstract", nullable = false)
    private String goodsAbstract;

    /**
     * 商品详细描述
     */
    @Column(name = "detail_content", nullable = false)
    private String detailContent;

    /**
     * 商品库存
     */
    @Column(name = "stock", nullable = false)
    private String stock;

    /**
     * 商品类型
     */
    @Column(name = "type", nullable = false)
    private String type;
//
//    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//    @JoinTable(name = "df_cart", joinColumns = {
//            @JoinColumn(name = "goods_id", referencedColumnName = "goods_id")},
//            inverseJoinColumns = {
//                    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
//            })
//    private Set<UserInfoEntity> userInfoEntities;
//
//    public Set<UserInfoEntity> getUserInfoEntities() {
//        return userInfoEntities;
//    }
//
//    public void setUserInfoEntities(Set<UserInfoEntity> userInfoEntities) {
//        this.userInfoEntities = userInfoEntities;
//    }

    public Long getId() {
        return goodsId;
    }

    public void setId(Long id) {
        this.goodsId = id;
    }

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

    public Long getClickNum() {
        return clickNum;
    }

    public void setClickNum(Long clickNum) {
        this.clickNum = clickNum;
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

    public String getStock() {
        return stock;
    }

    public void setStock(String stock) {
        this.stock = stock;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
