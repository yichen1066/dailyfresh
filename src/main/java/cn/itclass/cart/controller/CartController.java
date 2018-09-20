package cn.itclass.cart.controller;

import cn.itclass.auth.annotation.AuthFilter;
import cn.itclass.cart.entity.CartInfoDTO;
import cn.itclass.cart.entity.CartInfoVO;
import cn.itclass.cart.entity.DeleteCartInfoVO;
import cn.itclass.cart.entity.GetCartInfoVO;
import cn.itclass.cart.service.CartService;
import cn.itclass.common.entity.SystemResponseEnum;
import cn.itclass.common.utils.JsonResult;
import cn.itclass.goods.entity.GoodsInfoEntity;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.spring.web.json.Json;

import java.util.List;

@Api(value = "购物车")
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
    @AuthFilter
    @RequestMapping(value = "/getCartInfo", method = RequestMethod.POST)
    @ApiOperation(value = "查询购物车信息", httpMethod = "POST")
    public JsonResult getCartInfo(@RequestBody GetCartInfoVO cartInfoVO){
        List<CartInfoDTO> allCarts = this.cartService.findAllCarts(cartInfoVO.getUserId());
        return JsonResult.success(allCarts);
    }

    /**
     * 根据id删除购物车记录
     * @param deleteCartInfoVO
     * @return
     */
    @AuthFilter
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ApiOperation(value = "deleteCartInfo", httpMethod = "POST")
    public JsonResult deleteCartInfo(@RequestBody DeleteCartInfoVO deleteCartInfoVO){
        if(StringUtils.isNotEmpty(deleteCartInfoVO.getCartId())){
            this.cartService.deleteCartInfo(deleteCartInfoVO.getCartId());
            return JsonResult.success("删除购物车成功");
        }
        return JsonResult.fail(SystemResponseEnum.PARAM_ERROR, "cartId不能为空");
    }

    @AuthFilter
    @RequestMapping(value = "/clear", method = RequestMethod.POST)
    @ApiOperation(value = "clearCartInfo")
    public JsonResult clearCartInfo(@RequestBody DeleteCartInfoVO deleteCartInfoVO){
        this.cartService.deleteAllCartInfo(deleteCartInfoVO.getUserId());
        return JsonResult.success("清空购物车成功");
    }
}
