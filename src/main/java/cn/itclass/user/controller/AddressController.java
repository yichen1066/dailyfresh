package cn.itclass.user.controller;

import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(value = "收货地址信息")
@RequestMapping(value = "/user/address")
public class AddressController {

    private static final Logger logger = LoggerFactory.getLogger(AddressController.class);

    private static final String MODULE_NAME = "[user.address]{}{}{}";
}
