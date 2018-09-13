package cn.itclass.goods.service;

import cn.itclass.goods.entity.GoodsInfoEntity;
import cn.itclass.goods.entity.GoodsInfoVO;
import cn.itclass.goods.repository.GoodsRepository;
import org.springframework.data.domain.Sort;

import java.util.List;

public interface GoodsService {

    public List<GoodsInfoEntity> getGoodsList(Integer pageSize, Integer pageNum, Sort sort);

    public GoodsInfoEntity saveGoodsInfo(GoodsInfoVO goodsInfoVO);
}
