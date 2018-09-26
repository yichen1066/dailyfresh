package cn.itclass.order.repository;

import cn.itclass.order.entity.OrderInfoEntity;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface OrderInfoRepository extends JpaRepository<OrderInfoEntity, String>, JpaSpecificationExecutor<OrderInfoEntity> {

}
