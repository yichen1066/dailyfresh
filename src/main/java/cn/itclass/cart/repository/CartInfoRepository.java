package cn.itclass.cart.repository;

import cn.itclass.cart.entity.CartInfoEntity;
import cn.itclass.cart.entity.CartInfoVO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface CartInfoRepository extends JpaRepository<CartInfoEntity, Long> {


}
