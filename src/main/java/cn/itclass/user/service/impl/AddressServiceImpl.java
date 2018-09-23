package cn.itclass.user.service.impl;

import cn.itclass.auth.annotation.AuthFilter;
import cn.itclass.common.entity.SystemResponseEnum;
import cn.itclass.common.utils.JsonResult;
import cn.itclass.user.controller.AddressController;
import cn.itclass.user.entity.*;
import cn.itclass.user.repository.AddrUserRelRepository;
import cn.itclass.user.repository.AddressRepository;
import cn.itclass.user.repository.UserRepository;
import cn.itclass.user.service.AddressService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private AddrUserRelRepository addrUserRelRepository;

    @Autowired
    private UserRepository userRepository;

    /**
     * 添加用户收货地址
     * @param addAddressVO
     * @return
     */
    @AuthFilter
    @Override
    @Transactional
    public JsonResult addAddress(AddAddressVO addAddressVO) {
        //判断userID是否存在
        Optional<UserInfoEntity> userEntity = this.userRepository.findById(addAddressVO.getUserId());
        if(userEntity.isPresent()){
            //保存地址信息
            AddressEntity addressEntity = new AddressEntity();
            BeanUtils.copyProperties(addAddressVO.getAddress(), addressEntity);
            this.addressRepository.saveAndFlush(addressEntity);

            //保存地址与用户的关联信息
            AddrUserRelVO relVO = new AddrUserRelVO();
            relVO.setAddressId(addressEntity.getAddressId());
            relVO.setUserId(addAddressVO.getUserId());
            this.addAddressUserRel(relVO);
            return JsonResult.success("添加收货地址成功！");
        }
        return JsonResult.fail(SystemResponseEnum.PARAM_ERROR);
    }

    private void addAddressUserRel(AddrUserRelVO relVO) {
        AddrUserRelEntity relEntity = new AddrUserRelEntity();
        BeanUtils.copyProperties(relVO, relEntity);
        this.addrUserRelRepository.save(relEntity);
    }

    @Transactional
    @Override
    public void deleteAddress() {

    }

    private void deleteAddrUserRel() {

    }

    @Override
    public JsonResult getAddress(GetAddressVO getAddressVO) {
        List<Object[]> allAddress = this.addrUserRelRepository.findAllAddress(getAddressVO.getUserId());
        List<AddressDTO> addressDTOS = new ArrayList<AddressDTO>();

        for(Object[] object : allAddress){
            AddressDTO addressDTO = new AddressDTO();
            addressDTO.setAddressId((String)object[0]);
            addressDTO.setReceiver((String)object[1]);
            addressDTO.setLocation((String)object[2]);
            addressDTO.setDetailSite((String)object[3]);
            addressDTO.setZipCode((String)object[4]);
            addressDTO.setPhoneNumber((String)object[5]);
            addressDTOS.add(addressDTO);
        }
        return JsonResult.success(addressDTOS);
    }

    @Override
    public JsonResult updateDefaultAddressId(UserInfoVo userInfoVo) {
        int retCode =  this.addressRepository.updateDefaultAddressId(userInfoVo.getAddressId(), userInfoVo.getUserId());
        if(retCode == 1){
            return JsonResult.success("更新用户默认收货地址成功");
        }
        return JsonResult.fail(SystemResponseEnum.PARAM_ERROR);
    }
}
