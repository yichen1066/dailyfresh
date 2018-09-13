package cn.itclass.goods.repository;

import cn.itclass.goods.entity.GoodsInfoEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * 商品信息表
 *
 * @author Yi Chen
 *
 */

public interface GoodsRepository extends JpaRepository<GoodsInfoEntity, Long> {

//    @Query("select d from GoodsInfoEntity d")
//    Page<GoodsInfoEntity> findAllGoods(Pageable pageable);

//    @Override
//    Page<GoodsInfoEntity> findAll(Pageable pageable);
}
