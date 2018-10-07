package cn.itclass.cart.repository;

import cn.itclass.cart.entity.CartInfoDTO;
import cn.itclass.cart.entity.CartInfoEntity;
import cn.itclass.cart.entity.CartInfoVO;
import cn.itclass.goods.entity.GoodsInfoEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface CartInfoRepository extends JpaRepository<CartInfoEntity, Long> {

    /**
     * 根据用户id查询购物车信息
     * @param userId
     * @return
     */
    @Query("select new cn.itclass.cart.entity.CartInfoDTO(c,g)  from CartInfoEntity c left outer join GoodsInfoEntity g on g.goodsId = c.goodsId where c.userId = :userId")
    List<CartInfoDTO> findAllCarts(@Param("userId") String userId);

    /**
     * 根据id查询购物车信息
     * @param userId
     * @return
     */
    @Query("select new cn.itclass.cart.entity.CartInfoDTO(c,g)  from CartInfoEntity c left outer join GoodsInfoEntity g on g.goodsId = c.goodsId where c.userId = :userId and c.id = :cartId")
    CartInfoDTO findCartsById(@Param("userId") String userId, @Param("cartId") String cartId);

    /**
     * 删除一条购物车记录
     * @param id
     */
    @Transactional
    @Modifying
    @Query("delete from CartInfoEntity c where c.id=:id")
    void deleteByCartId(@Param("id") String id);

    /**
     * 清空购物车
     * @param userId
     */
    @Transactional
    @Modifying
    @Query("delete from CartInfoEntity c where c.userId=:userId")
    void deleteAllByUserId(@Param("userId") String userId);

    /**
     * 根据商品id查询购物车信息
     */
    CartInfoEntity findByGoodsId(String goodsId);
}
