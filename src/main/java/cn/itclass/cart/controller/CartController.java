package cn.itclass.cart.controller;

import cn.itclass.cart.entity.CartInfoDTO;
import cn.itclass.cart.entity.CartInfoVO;
import cn.itclass.cart.service.CartService;
import cn.itclass.common.utils.JsonResult;
import cn.itclass.goods.entity.GoodsInfoEntity;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "购物车信息")
@RestController
@RequestMapping(value = "/cart")
public class CartController {

    @Autowired
    private CartService cartService;

    private static final Logger logger = LoggerFactory.getLogger(CartController.class);

    private static final String MODULE_NAME = "[cart]{}{}{}";

    /**
     * 添加购物车信息
     * @param cartInfoVO
     * @return
     */
    @RequestMapping(value = "/addItem", method = RequestMethod.POST)
    @ApiOperation(value = "添加商品购物车", httpMethod = "POST")
    public JsonResult addCartInfo(@RequestBody @Validated CartInfoVO cartInfoVO){
        this.cartService.addCartInfo(cartInfoVO);
        logger.info(MODULE_NAME, "addCartInfo", "添加购物车成功");
        return JsonResult.success("添加购物车成功");
    }

    /**
     * 查询购物车信息
     * @param user_id
     * @return
     */
    @RequestMapping(value = "/findCartInfo", method = RequestMethod.POST)
    @ApiOperation(value = "查询购物车信息", httpMethod = "POST")
    public JsonResult findCartInfo(@RequestParam String user_id){
        List<CartInfoDTO> allCarts = this.cartService.findAllCarts(user_id);
        return JsonResult.success(allCarts);
    }
}
