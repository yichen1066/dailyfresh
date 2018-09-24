package cn.itclass.user.service;

import cn.itclass.common.utils.JsonResult;
import cn.itclass.user.entity.AddressVO;
import cn.itclass.user.entity.DelAddressVO;
import cn.itclass.user.entity.GetAddressVO;
import cn.itclass.user.entity.UserInfoVo;

public interface AddressService {
    public JsonResult addAddress(AddressVO addressVO);

    public JsonResult deleteAddress(DelAddressVO addressVO);

    public JsonResult getAddress(GetAddressVO getAddressVO);

    public JsonResult updateDefaultAddressId(UserInfoVo userInfoVo);
}
