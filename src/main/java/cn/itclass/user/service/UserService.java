package cn.itclass.user.service;  
      
import java.util.*;
import java.util.Map.Entry;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.servlet.http.HttpServletRequest;

import cn.itclass.user.entity.UserInfoEntity;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import cn.itclass.common.utils.JsonResult;
import cn.itclass.user.entity.UserVo;
import cn.itclass.user.repository.UserRepository;

/**
 * user相关的service
 * 
 * @author Yi Chen
 *
 */

@Service  
public class UserService {

	static private final Logger logger = LoggerFactory.getLogger(UserService.class);
    
    @Autowired  
    private UserRepository userRepository;

    @Value("${page.size}")
    private Integer page_size;

	/**
	 *	根据指定条件查询
	 * @param userVo
	 * @return
	 */
	public List<UserInfoEntity> queryListByConditions(UserVo userVo){
    	Specification<UserInfoEntity> specification = new Specification<UserInfoEntity>() {

			@Override
			public Predicate toPredicate(Root<UserInfoEntity> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
				List<Predicate> predicates = new ArrayList<Predicate>();
				
				if(StringUtils.isNotBlank(userVo.getUserAccount())){
					predicates.add(criteriaBuilder.equal(root.get("userAccount"), userVo.getUserAccount()));
				}
				
				return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
			}
    		
		};
		return this.userRepository.findAll(specification);
    }

	/**
	 * 注册用户信息
	 * @param userVo
	 * @return
	 */
	public JsonResult registerAccount(UserVo userVo){
    	UserInfoEntity userInfoEntity = new UserInfoEntity();
		BeanUtils.copyProperties(userVo, userInfoEntity);

		userInfoEntity.setRegistrationTime(new Date());
		this.userRepository.save(userInfoEntity);
		return JsonResult.success();
	}

	/**
	 * 查询指定账户是否已被注册
	 * @param account
	 * @return
	 */
	public boolean isUserAccountExsit(String account){
		UserInfoEntity userEntity = this.userRepository.findByUserAccountIs(account);
		if(userEntity == null){
			return false;
		}else {
			return true;
		}
	}

	/**
	 * 查询账户信息
	 */
	public UserInfoEntity queryAccountInfo(String account){
		return this.userRepository.findByUserAccountIs(account);
	}
}