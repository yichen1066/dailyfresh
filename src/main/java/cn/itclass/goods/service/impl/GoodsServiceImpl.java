package cn.itclass.goods.service.impl;

import cn.itclass.common.entity.SystemResponseEnum;
import cn.itclass.common.utils.JsonResult;
import cn.itclass.goods.entity.GoodsInfoEntity;
import cn.itclass.goods.entity.GoodsInfoVO;
import cn.itclass.goods.repository.GoodsRepository;
import cn.itclass.goods.service.GoodsService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    private GoodsRepository goodsRepository;

    /**
     * 分页查询商品信息
     * @param pageSize
     * @param pageNum
     * @param sort
     * @return
     */
    @Override
    public List<GoodsInfoEntity> getGoodsList(Integer pageSize, Integer pageNum, Sort sort) {
        Pageable pageable = PageRequest.of(pageNum, pageSize, sort);
        List<GoodsInfoEntity> all = this.goodsRepository.findAll();
        Page<GoodsInfoEntity> allGoods = this.goodsRepository.findAll(pageable);
        Iterator<GoodsInfoEntity> iterator = allGoods.iterator();

        List<GoodsInfoEntity> goodsList = new ArrayList<GoodsInfoEntity>();
        while(iterator.hasNext()){
            goodsList.add(iterator.next());
        }
        return  goodsList;
    }

    /**
     * 保存商品信息
     * @param goodsInfoVO
     * @return
     */
    @Override
    public GoodsInfoEntity saveGoodsInfo(GoodsInfoVO goodsInfoVO) {
        GoodsInfoEntity goodsInfoEntity = new GoodsInfoEntity();
        BeanUtils.copyProperties(goodsInfoVO, goodsInfoEntity);
        return this.goodsRepository.save(goodsInfoEntity);
    }

    /**
     * 根据id删除商品
     * @param id
     */
    @Override
    public void deleteGoodsById(Long id) {
        this.goodsRepository.deleteById(id);
    }
}
