package cn.itclass.user.controller;

import cn.itclass.auth.annotation.AuthFilter;
import cn.itclass.common.entity.SystemResponseEnum;
import cn.itclass.common.utils.JsonResult;
import cn.itclass.user.entity.AddAddressVO;
import cn.itclass.user.entity.GetAddressVO;
import cn.itclass.user.entity.UserInfoVo;
import cn.itclass.user.service.AddressService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.spring.web.json.Json;

@RestController
@Api(value = "收货地址信息")
@RequestMapping(value = "/user/address")
public class AddressController {

    private static final Logger logger = LoggerFactory.getLogger(AddressController.class);

    private static final String MODULE_NAME = "[user.address]{}{}{}";

    @Autowired
    private AddressService addressService;

    @AuthFilter
    @RequestMapping(value = "/add")
    @ApiOperation(value = "添加收货地址", httpMethod = "POST")
    public JsonResult addAddrByUser(@RequestBody  AddAddressVO addAddressVO){
        return this.addressService.addAddress(addAddressVO);
    }

    @AuthFilter
    @RequestMapping(value = "/getAll")
    @ApiOperation(value = "查询用户所有的收货地址", httpMethod = "POST")
    public JsonResult getAllAddress(@RequestBody @ApiParam("指定用户的id") GetAddressVO getAddressVO){
        return this.addressService.getAddress(getAddressVO);
    }

    @AuthFilter
    @RequestMapping(value = "/updateDefaultAddressId")
    @ApiOperation(value = "更新默认收货地址", httpMethod = "POST")
    public JsonResult updateDefaultAddressId(@RequestBody UserInfoVo userInfoVo){
        JsonResult jsonResult = this.addressService.updateDefaultAddressId(userInfoVo);
        if(jsonResult.getResultCode() != SystemResponseEnum.SUCCESS.name()){
            logger.error(MODULE_NAME, "updateDefaultAddressId", "更新默认收货地址失败， addressId=", userInfoVo.getAddressId());
        }
        return jsonResult;
    }
}
