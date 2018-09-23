package cn.itclass.user.repository;

import cn.itclass.user.entity.AddrUserRelEntity;
import cn.itclass.user.entity.AddressEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AddrUserRelRepository extends JpaRepository<AddrUserRelEntity, String> {
    @Query("select aur.addressId, ae.receiver, ae.location, ae.detailSite, ae.zipCode, ae.phoneNumber from AddrUserRelEntity aur left outer join AddressEntity ae on aur.addressId=ae.addressId where aur.userId=:userId")
    List<Object[]> findAllAddress(@Param("userId") String userId);
}
