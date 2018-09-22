package cn.itclass.user.entity;

import cn.itclass.common.entity.BaseEntity;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "address_user_rel")
public class AddressUserRelationshipEntity extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 地址与用户关系表id，主键
     */
    @Id
    @GenericGenerator(name = "uuidGenerator", strategy = "uuid")
    @GeneratedValue(generator = "uuidGenerator")
    private String id;

    @Column(name = "address_id")
    private String addressId;

    @Column(name = "user_id")
    private String userId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
