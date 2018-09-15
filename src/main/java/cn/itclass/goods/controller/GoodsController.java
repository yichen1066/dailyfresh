package cn.itclass.goods.controller;

import cn.itclass.common.entity.SystemResponseEnum;
import cn.itclass.common.utils.JsonResult;
import cn.itclass.goods.entity.GoodsInfoEntity;
import cn.itclass.goods.entity.GoodsInfoVO;
import cn.itclass.common.entity.SystemProperties;
import cn.itclass.goods.service.GoodsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@Api(tags = "商品信息")
@RestController
@RequestMapping(value = "/goods")
public class GoodsController {
    @Autowired
    private GoodsService goodsService;

    @Autowired
    private SystemProperties systemProperties;

    private static final Logger logger = LoggerFactory.getLogger(GoodsController.class);
    private static final String MODULE_NAME = "[goods]{}{}{}";

    /**
     * 查询商品列表
     * @param pageNum
     * @param sortType
     * @param sortDirection
     * @return
     */
    @RequestMapping(value = "/getList",method = RequestMethod.POST)
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
            logger.error(MODULE_NAME, "getList", "查询参数错误, sortType=", sortType);
            return JsonResult.fail(SystemResponseEnum.PARAM_ERROR);
        }

        //判断排序方向，正向或逆向
        Sort.Direction direction = null;
        if(sortDirection == 1){
            direction = Sort.Direction.ASC;
        }else if(sortDirection == 2){
            direction = Sort.Direction.DESC;
        }else {
            logger.error(MODULE_NAME, "getList", "查询参数错误, sortDirection=", sortDirection);
            return JsonResult.fail(SystemResponseEnum.PARAM_ERROR);
        }

        Sort sort = new Sort(direction, type);
        List<GoodsInfoEntity> goodsList = this.goodsService.getGoodsList(systemProperties.getPageSize(), pageNum, sort);

        logger.info(MODULE_NAME, "getList", "查询商品列表成功:finish");
        return JsonResult.success(goodsList);
    }

    @RequestMapping(value = "/saveGoodsInfo", method = RequestMethod.POST)
    @ApiOperation(value = "保存商品信息", httpMethod = "POST")
    public JsonResult saveGoodsInfo(@RequestBody GoodsInfoVO goodsInfoVO){
        logger.info(MODULE_NAME, "saveGoodsInfo", "保存商品信息成功");
        return JsonResult.success(this.goodsService.saveGoodsInfo(goodsInfoVO));
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
    @ApiOperation(value = "删除商品信息", httpMethod = "POST")
    public JsonResult delete(@PathVariable(value = "id") String id){
        this.goodsService.deleteGoodsById(Long.valueOf(id));
        return JsonResult.success("删除商品成功");
    }
}
