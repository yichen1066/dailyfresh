package cn.itclass.user.service;

import cn.itclass.common.utils.JsonResult;
import cn.itclass.user.entity.AddAddressVO;
import cn.itclass.user.entity.AddrUserRelVO;
import cn.itclass.user.entity.GetAddressVO;
import cn.itclass.user.entity.UserInfoVo;

public interface AddressService {
    public JsonResult addAddress(AddAddressVO addAddressVO);

    public void deleteAddress();

    public JsonResult getAddress(GetAddressVO getAddressVO);

    public JsonResult updateDefaultAddressId(UserInfoVo userInfoVo);
}
