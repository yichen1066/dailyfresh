package cn.itclass.goods.controller;

import cn.itclass.common.entity.SystemResponseEnum;
import cn.itclass.common.utils.JsonResult;
import cn.itclass.goods.entity.GoodsInfoEntity;
import cn.itclass.goods.entity.GoodsInfoVO;
import cn.itclass.goods.entity.SystemProperties;
import cn.itclass.goods.service.GoodsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "商品信息")
@RestController
@RequestMapping(value = "/goods")
public class GoodsController {
    @Autowired
    private GoodsService goodsService;

    @Autowired
    private SystemProperties systemProperties;

    /**
     * 查询商品列表
     * @param pageNum
     * @param sortType
     * @param sortDirection
     * @return
     */
    @RequestMapping(value = "/getGoodsList",method = RequestMethod.POST)
    @ApiOperation(value = "查询商品列表", httpMethod = "POST")
    public JsonResult getGoodsList(@RequestParam Integer pageNum, @RequestParam Integer sortType, @RequestParam Integer sortDirection){
        //判断排序的条件
        String type = null;
        if(sortType == 1){
            type = "goodsId";
        }else if (sortType == 2){
            type = "clickNum";
        }else if (sortType == 3){
            type = "sellPrice";
        }else {
            return JsonResult.fail(SystemResponseEnum.PARAM_ERROR);
        }

        //判断排序方向，正向或逆向
        Sort.Direction direction = null;
        if(sortDirection == 1){
            direction = Sort.Direction.ASC;
        }else if(sortDirection == 2){
            direction = Sort.Direction.DESC;
        }else {
            return JsonResult.fail(SystemResponseEnum.PARAM_ERROR);
        }

        Sort sort = new Sort(direction, type);
        List<GoodsInfoEntity> goodsList = this.goodsService.getGoodsList(systemProperties.getPageSize(), pageNum, sort);
        return JsonResult.success(goodsList);
    }

    @RequestMapping(value = "/saveGoodsInfo", method = RequestMethod.POST)
    @ApiOperation(value = "保存商品信息", httpMethod = "POST")
    public JsonResult saveGoodsInfo(@RequestBody GoodsInfoVO goodsInfoVO){
        return JsonResult.success(this.goodsService.saveGoodsInfo(goodsInfoVO));
    }
}
