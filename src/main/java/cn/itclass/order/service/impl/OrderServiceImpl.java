package cn.itclass.order.service.impl;

import cn.itclass.cart.entity.CartInfoDTO;
import cn.itclass.cart.entity.GetCartInfoVO;
import cn.itclass.cart.repository.CartInfoRepository;
import cn.itclass.order.model.vo.PlaceOrderVO;
import cn.itclass.order.repository.OrderInfoRepository;
import cn.itclass.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class OrderServiceImpl implements OrderService {

    @Autowired
    private CartInfoRepository cartInfoRepository;

    /**
     * 下订单
     */
    @Transactional
    @Override
    public void placeOrder(PlaceOrderVO placeOrderVO) {
        GetCartInfoVO getCartInfoVO = new GetCartInfoVO();
        getCartInfoVO.setUserId(placeOrderVO.getUserId());

        List<String> cartIds = placeOrderVO.getCartIds();
        getCartInfoVO.setCartIds(cartIds);
        for(int i = 0; i < placeOrderVO.getCartIds().size(); i++){
            CartInfoDTO cartInfoDTO = this.cartInfoRepository.findCartsById(placeOrderVO.getUserId(), cartIds.get(i));
        }
    }
}
