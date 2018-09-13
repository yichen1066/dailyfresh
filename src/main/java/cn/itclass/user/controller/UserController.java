package cn.itclass.user.controller;

import cn.itclass.common.entity.SystemResponseEnum;
import cn.itclass.common.utils.JsonResult;
import cn.itclass.user.entity.UserInfoEntity;
import cn.itclass.user.entity.UserVo;
import cn.itclass.user.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.spring.web.json.Json;

/**  
 * @ClassName: UserController   
 * @Description: 用户Controller
 */  
@RestController
@Api(tags = "用户信息")
public class UserController {

    @Autowired  
    private UserService userService;

    /**
     * 注册账户
     * @param userVo
     * @return
     */
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    @ApiOperation(value = "账户注册", httpMethod = "POST")
    public JsonResult regitser(@RequestBody @Validated UserVo userVo){
        return this.userService.registerAccount(userVo);
    }

    /**
     * 查询指定账户是否被注册
     * @param account
     * @return
     */
    @RequestMapping(value = "/findAccountIsExist", method = RequestMethod.POST)
    @ApiOperation(value = "查询指定账户是否被注册", httpMethod = "POST")
    public JsonResult isAccountExist(@RequestParam String account){
        boolean isExist = this.userService.isUserAccountExsit(account);
        return JsonResult.success(isExist);
    }

    /**
     * 查询账户信息
     * @param account
     * @return
     */
    @RequestMapping(value = "/queryByAccount", method = RequestMethod.POST)
    @ApiOperation(value = "根据账户名查询用户信息", httpMethod = "POST")
    public JsonResult queryByAccount(@RequestParam String account){
        if("".equals(account)){
            return JsonResult.fail(SystemResponseEnum.PARAM_EMPTY_FAIL);
        }

        if(this.userService.isUserAccountExsit(account)){
            UserInfoEntity userEntity = this.userService.queryAccountInfo(account);
            return JsonResult.success(userEntity);
        }else {
            return JsonResult.success();
        }
    }

}