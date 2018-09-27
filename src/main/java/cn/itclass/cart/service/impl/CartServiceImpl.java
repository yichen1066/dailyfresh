package cn.itclass.cart.service.impl;

import cn.itclass.cart.entity.CartInfoDTO;
import cn.itclass.cart.entity.CartInfoEntity;
import cn.itclass.cart.entity.CartInfoVO;
import cn.itclass.cart.entity.GetCartInfoVO;
import cn.itclass.cart.repository.CartInfoRepository;
import cn.itclass.cart.service.CartService;
import cn.itclass.goods.entity.GoodsInfoEntity;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    private CartInfoRepository cartInfoRepository;

    @Override
    public void addCartInfo(CartInfoVO cartInfoVO) {
        CartInfoEntity cartInfo = this.cartInfoRepository.findByGoodsId(cartInfoVO.getGoodsId());
        if(cartInfo == null){
            CartInfoEntity cartInfoEntity = new CartInfoEntity();
            BeanUtils.copyProperties(cartInfoVO, cartInfoEntity);
            this.cartInfoRepository.save(cartInfoEntity);
            return;
        }
        cartInfo.setCount(cartInfo.getCount() + cartInfoVO.getCount());
        this.cartInfoRepository.save(cartInfo);
    }

    @Override
    public List<CartInfoDTO> findAllCarts(String userId) {
        List<CartInfoDTO> goodsInfoEntities = this.cartInfoRepository.findAllCarts(userId);
        return goodsInfoEntities;
    }

    /**
     * 根据id删除购物车信息
     * @param cartId
     */
    @Override
    public void deleteCartInfo(String cartId) {
        this.cartInfoRepository.deleteByCartId(cartId);
    }

    /**
     * 清空个人购物车
     */
    @Override
    public void deleteAllCartInfo(String userId) {
        this.cartInfoRepository.deleteAllByUserId(userId);
    }

    @Override
    public List<CartInfoDTO> findAllByCartId(GetCartInfoVO cartInfoVO) {
        List<CartInfoDTO> cartInfoDTOS = new ArrayList<CartInfoDTO>();
        for(String cartId : cartInfoVO.getCartIds()){
            CartInfoDTO cartInfo = this.cartInfoRepository.findCartsById(cartInfoVO.getUserId(), cartId);
            cartInfoDTOS.add(cartInfo);
        }
        return cartInfoDTOS;
    }
}
