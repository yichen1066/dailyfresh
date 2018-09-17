package cn.itclass.cart.service.impl;

import cn.itclass.cart.entity.CartInfoDTO;
import cn.itclass.cart.entity.CartInfoEntity;
import cn.itclass.cart.entity.CartInfoVO;
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
        CartInfoEntity cartInfoEntity = new CartInfoEntity();
        BeanUtils.copyProperties(cartInfoVO, cartInfoEntity);
        this.cartInfoRepository.save(cartInfoEntity);
    }

    @Override
    public List<CartInfoDTO> findAllCarts(String userId) {
        List<Object[]> goodsInfoEntities = this.cartInfoRepository.findAllCarts(userId);
        List<CartInfoDTO> cartInfoDTOS = new ArrayList<CartInfoDTO>();

        //object转为dto
        for(Object[] entity : goodsInfoEntities){
            CartInfoDTO cartInfoDTO = new CartInfoDTO();
            cartInfoDTO.setDefaultPic((String)entity[0]);
            cartInfoDTO.setGoodsTitle((String)entity[1]);
            cartInfoDTO.setSellPrice((BigDecimal)entity[2]);
            cartInfoDTO.setPriceUnit((String)entity[3]);
            cartInfoDTO.setStock((Integer)entity[4]);
            cartInfoDTO.setCount((Integer)entity[5]);
            cartInfoDTOS.add(cartInfoDTO);
        }
        return cartInfoDTOS;
    }
}
