package cn.itclass.order.service;

import cn.itclass.order.model.vo.PlaceOrderVO;
import org.springframework.stereotype.Service;

public interface OrderService {
    public void placeOrder(PlaceOrderVO placeOrderVO);
}
