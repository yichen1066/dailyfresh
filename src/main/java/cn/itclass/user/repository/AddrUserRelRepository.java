package cn.itclass.user.repository;

import cn.itclass.user.entity.AddrUserRelEntity;
import cn.itclass.user.entity.AddressEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AddrUserRelRepository extends JpaRepository<AddrUserRelEntity, String> {
    /**
     * 查询用户添加的所有收货地址信息
     * @param userId
     * @return
     */
    @Query("select aur.addressId, ae.receiver, ae.location, ae.detailSite, ae.zipCode, ae.phoneNumber from AddrUserRelEntity aur left outer join AddressEntity ae on aur.addressId=ae.addressId where aur.userId=:userId")
    List<Object[]> findAllAddress(@Param("userId") String userId);

    /**
     * 根据用户id和地址id删除关联表
     * @param addressId
     * @param userId
     * @return
     */
    @Modifying
    @Query("delete from AddrUserRelEntity are where are.addressId = :addressId and are.userId=:userId")
    int deleteByAddressIdAAndUserId(@Param("addressId") String addressId, @Param("userId") String userId);

    /**
     * 根据addressId和userId查询关联表信息
     * @param addressId
     * @param userId
     * @return
     */
    AddrUserRelEntity findByAddressIdAndUserId(String addressId, String userId);
}
