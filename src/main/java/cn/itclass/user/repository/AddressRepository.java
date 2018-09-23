package cn.itclass.user.repository;

import cn.itclass.common.entity.BaseEntity;
import cn.itclass.user.entity.AddrUserRelEntity;
import cn.itclass.user.entity.AddressEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * 收货地址数据仓库接口
 */
public interface AddressRepository extends JpaRepository<AddressEntity, String> {
}
