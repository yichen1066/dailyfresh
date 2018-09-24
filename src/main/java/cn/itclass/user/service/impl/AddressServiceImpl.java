package cn.itclass.user.service.impl;

import cn.itclass.auth.annotation.AuthFilter;
import cn.itclass.common.entity.SystemResponseEnum;
import cn.itclass.common.utils.JsonResult;
import cn.itclass.user.entity.*;
import cn.itclass.user.repository.AddrUserRelRepository;
import cn.itclass.user.repository.AddressRepository;
import cn.itclass.user.repository.UserRepository;
import cn.itclass.user.service.AddressService;

import com.alibaba.fastjson.JSONObject;
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

    private static final Logger logger = LoggerFactory.getLogger(AddressServiceImpl.class);

    private static final String MODULE_NAME = "[addressServive]{}{}{}";

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
    public JsonResult addAddress(AddressVO addressVO) {
        //判断userID是否存在
        UserInfoEntity userEntity = this.userRepository.findByUserId(addressVO.getUserId());
        if(userEntity != null){
            //保存地址信息
            AddressEntity addressEntity = new AddressEntity();
            BeanUtils.copyProperties(addressVO.getAddress(), addressEntity);
            this.addressRepository.saveAndFlush(addressEntity);

            //保存地址与用户的关联信息
            AddrUserRelVO relVO = new AddrUserRelVO();
            relVO.setAddressId(addressEntity.getAddressId());
            relVO.setUserId(addressVO.getUserId());
            this.addAddressUserRel(relVO);
            logger.info(MODULE_NAME, "[addAddress]", "添加收货地址成功：", JSONObject.toJSONString(addressEntity));
            return JsonResult.success("添加收货地址成功！");
        }
        logger.error(MODULE_NAME, "[addAddress]", "添加收货地址失败：", addressVO.getUserId());
        return JsonResult.fail(SystemResponseEnum.PARAM_ERROR);
    }

    /**
     * 增加地址与用户关联表信息
     * @param relVO
     */
    private void addAddressUserRel(AddrUserRelVO relVO) {
        AddrUserRelEntity relEntity = new AddrUserRelEntity();
        BeanUtils.copyProperties(relVO, relEntity);
        this.addrUserRelRepository.save(relEntity);
    }

    /**
     * 删除收货地址信息
     * @param addressVO
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public JsonResult deleteAddress(DelAddressVO addressVO) {
        AddressEntity addressEntity = this.addressRepository.findByAddressId(addressVO.getAddressId());
        AddrUserRelEntity addrUserRelEntity = this.addrUserRelRepository.findByAddressIdAndUserId(addressVO.getAddressId(), addressVO.getUserId());
        if((addressEntity != null) && (addrUserRelEntity != null)){
            this.addressRepository.delete(addressEntity);
            logger.info(MODULE_NAME, "[deleteAddress]", "删除收货地址成功", JSONObject.toJSONString(addressEntity));
            this.deleteAddrUserRel(addrUserRelEntity);
            logger.info(MODULE_NAME, "[deleteAddress]", "删除收货地址与用户的映射信息成功", JSONObject.toJSONString(addrUserRelEntity));
            return JsonResult.success();
        }
        logger.error(MODULE_NAME, "[deleteAddress]", "删除收货地址失败", JSONObject.toJSONString(addressVO));
        return JsonResult.fail(SystemResponseEnum.PARAM_ERROR);
    }

    /**
     * 删除地址表与用户表的关联信息
     * @param addrUserRelEntity
     */
    private void deleteAddrUserRel(AddrUserRelEntity addrUserRelEntity) {
        this.addrUserRelRepository.delete(addrUserRelEntity);
    }

    /**
     * 获取用户添加的所有收货地址
     * @param getAddressVO
     * @return
     */
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

    /**
     * 更新默认收货地址
     * @param userInfoVo
     * @return
     */
    @Override
    public JsonResult updateDefaultAddressId(UserInfoVo userInfoVo) {
        int retCode =  this.addressRepository.updateDefaultAddressId(userInfoVo.getAddressId(), userInfoVo.getUserId());
        if(retCode == 1){
            return JsonResult.success("更新用户默认收货地址成功");
        }
        return JsonResult.fail(SystemResponseEnum.PARAM_ERROR);
    }
}
