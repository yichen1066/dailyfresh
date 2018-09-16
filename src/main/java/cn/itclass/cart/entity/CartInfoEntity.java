package cn.itclass.cart.entity;

import cn.itclass.common.entity.BaseEntity;

import javax.persistence.*;

@Entity
@Table(name="df_cart")
public class CartInfoEntity extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 购物车id，主键
     */
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="cart_id")
    private Long id;

    /**
     * 每一个购物车的购物数量
     */
    @Column(name = "count")
    private Integer count;

    /**
     * 商品id
     */
    @Column(name = "goods_id")
    private Long goodsId;

    /**
     * 用户id
     */
    @Column(name = "user_id")
    private Long userId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
