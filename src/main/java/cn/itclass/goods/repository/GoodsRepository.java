package cn.itclass.goods.repository;

import cn.itclass.goods.entity.GoodsInfoEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * 商品信息表
 *
 * @author Yi Chen
 *
 */

public interface GoodsRepository extends JpaRepository<GoodsInfoEntity, Long> {
    @Modifying
    @Query("update GoodsInfoEntity g set g.clickNum = g.clickNum + 1 where g.id = :goodsId")
    int addGoodsView(@Param("goodsId") String goodsId);

    @Modifying
    @Query("delete from GoodsInfoEntity g where g.goodsId = :goodsId")
    void deleteById(@Param("goodsId") String goodsId);
}
