package cn.itclass.user.service;

import cn.itclass.common.utils.JsonResult;
import cn.itclass.user.entity.AddressVO;
import cn.itclass.user.entity.ModifyAddressVO;
import cn.itclass.user.entity.GetAddressVO;
import cn.itclass.user.entity.UserInfoVo;

public interface AddressService {
    public JsonResult saveOrUpdateAddress(AddressVO addressVO);

    public JsonResult deleteAddress(ModifyAddressVO addressVO);

    public JsonResult getAddress(GetAddressVO getAddressVO);

    public JsonResult updateDefaultAddressId(ModifyAddressVO addressVO);
}
