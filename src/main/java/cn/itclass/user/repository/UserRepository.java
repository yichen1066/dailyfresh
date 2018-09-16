package cn.itclass.user.repository;

import cn.itclass.user.entity.UserInfoEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

/**
 * 定义数据库仓库(t_user)
 * 
 * @author Yi Chen
 *
 */
public interface UserRepository extends JpaRepository<UserInfoEntity, Integer>, JpaSpecificationExecutor<UserInfoEntity> {
	/**
	 *	根据用户名分页查询
	 * @param userName
	 * @param pageable
	 * @return
	 */
	Page<UserInfoEntity> findByUserAccountIs(String userAccount, Pageable pageable);

	/**
	 * 根据用户名查询唯一用户
	 * @param userAccount
	 * @return
	 */
	UserInfoEntity findByUserAccountIs(String userAccount);

	@Modifying
	@Query(value = "update UserInfoEntity u set u.realName = :realName, u.nickName = :nickName, u.birthdate = :birthdate, u.residence = :residence where u.userAccount = :userAccount")
	int updateUserByRealNameAndNickNameAndBirthDateAndResidence(@Param("userAccount") String userAccount,
																 @Param("realName") String realName,
																 @Param("nickName") String nickName,
																 @Param("birthdate") Date birthdate,
																 @Param("residence") String residence);

}
