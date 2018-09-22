package cn.itclass.user.service.impl;

import cn.itclass.user.entity.AddAddressVO;
import cn.itclass.user.entity.AddressEntity;
import cn.itclass.user.repository.AddressRepository;
import cn.itclass.user.service.AddressService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    private AddressRepository addressRepository;

    @Override
    public void addAddress(AddAddressVO addAddressVO) {
        AddressEntity addressEntity = new AddressEntity();
        BeanUtils.copyProperties(addAddressVO, addressEntity);
        this.addressRepository.save(addressEntity);
    }
}
