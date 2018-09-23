package cn.itclass.user.service;

import cn.itclass.common.utils.JsonResult;
import cn.itclass.user.entity.AddAddressVO;
import cn.itclass.user.entity.AddrUserRelVO;

public interface AddressService {
    public JsonResult addAddress(AddAddressVO addAddressVO);

    public void addAddressUserRel(AddrUserRelVO relVO);
}
