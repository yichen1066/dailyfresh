package cn.itclass.user.repository;

import cn.itclass.user.entity.AddressEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 收货地址数据仓库接口
 */
public interface AddressRepository extends JpaRepository<AddressEntity, String> {
    
}
