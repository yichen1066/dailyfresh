package cn.itclass.cart.service.impl;

import cn.itclass.cart.entity.CartInfoEntity;
import cn.itclass.cart.entity.CartInfoVO;
import cn.itclass.cart.repository.CartInfoRepository;
import cn.itclass.cart.service.CartService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    private CartInfoRepository cartInfoRepository;

    @Override
    public void addCartInfo(CartInfoVO cartInfoVO) {
        CartInfoEntity cartInfoEntity = new CartInfoEntity();
        BeanUtils.copyProperties(cartInfoVO, cartInfoEntity);
        this.cartInfoRepository.save(cartInfoEntity);
    }
}
