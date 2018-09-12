package cn.itclass.user.entity;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(UserInfoEntity.class)
public abstract class UserInfoEntity_ {

	public static volatile SingularAttribute<UserInfoEntity, Date> registrationTime;
	public static volatile SingularAttribute<UserInfoEntity, String> realName;
	public static volatile SingularAttribute<UserInfoEntity, String> password;
	public static volatile SingularAttribute<UserInfoEntity, String> phoneNumber;
	public static volatile SingularAttribute<UserInfoEntity, Date> loginTime;
	public static volatile SingularAttribute<UserInfoEntity, Date> birthdate;
	public static volatile SingularAttribute<UserInfoEntity, String> nickName;
	public static volatile SingularAttribute<UserInfoEntity, String> userAccount;
	public static volatile SingularAttribute<UserInfoEntity, Long> id;
	public static volatile SingularAttribute<UserInfoEntity, Integer> defaultAddressId;
	public static volatile SingularAttribute<UserInfoEntity, String> avatar;
	public static volatile SingularAttribute<UserInfoEntity, String> residence;

}

