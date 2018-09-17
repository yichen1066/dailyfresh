package cn.itclass.cart.service;

import cn.itclass.cart.entity.CartInfoDTO;
import cn.itclass.cart.entity.CartInfoVO;
import cn.itclass.goods.entity.GoodsInfoEntity;

import java.util.List;

public interface CartService {
    public void addCartInfo(CartInfoVO cartInfoVO);

    List<CartInfoDTO> findAllCarts(String userId);
}
