package cn.itclass.cart.entity;

import cn.itclass.common.entity.BaseEntity;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name="df_cart")
public class CartInfoEntity extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 购物车id，主键
     */
    @Id
    @GenericGenerator(name = "uuidGenerator", strategy = "uuid")
    @GeneratedValue(generator = "uuidGenerator")
    @Column(name="cart_id", length = 32)
    private String id;

    /**
     * 每一个购物车的购物数量
     */
    @Column(name = "count")
    private Integer count;

    /**
     * 商品id
     */
    @Column(name = "goods_id", length = 32)
    private String goodsId;

    /**
     * 用户id
     */
    @Column(name = "user_id", length = 32)
    private String userId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

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
