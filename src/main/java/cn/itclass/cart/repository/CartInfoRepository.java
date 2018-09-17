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

import java.util.List;

public interface CartInfoRepository extends JpaRepository<CartInfoEntity, Long> {

    @Query("select g.defaultPic, g.goodsTitle, g.sellPrice, g.priceUnit, g.stock, c.count from CartInfoEntity c left outer join GoodsInfoEntity g on g.goodsId = c.goodsId where c.userId = :userId")
    List<Object[]> findAllCarts(@Param("userId") String userId);
}
