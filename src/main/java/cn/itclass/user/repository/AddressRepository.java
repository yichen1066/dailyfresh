package cn.itclass.user.repository;

import cn.itclass.common.entity.BaseEntity;
import cn.itclass.user.entity.AddrUserRelEntity;
import cn.itclass.user.entity.AddressEntity;
import cn.itclass.user.entity.UserInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

/**
 * 收货地址数据仓库接口
 */
public interface AddressRepository extends JpaRepository<AddressEntity, String> {
    /**
     * 更新用户默认的收货地址
     * @param addressId
     * @return
     */
    @Transactional
    @Modifying
    @Query(value = "update UserInfoEntity u set u.defaultAddressId = :addressId where u.userId = :userId")
    int updateDefaultAddressId(@Param("addressId") String addressId, @Param("userId") String userId);

    /**
     * 根据addressId查询地址信息
     * @param addressId
     * @return
     */
    AddressEntity findByAddressId(String addressId);
}
