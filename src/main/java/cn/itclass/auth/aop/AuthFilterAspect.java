package cn.itclass.auth.aop;

import cn.itclass.auth.exception.AuthFilterException;
import cn.itclass.common.entity.BaseVO;
import org.apache.commons.lang.StringUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AuthFilterAspect {
    @Pointcut("@annotation(cn.itclass.auth.annotation.AuthFilter)")
    public void authCheckPointcut(){
    }

    @Before(value = "authCheckPointcut()")
    public void authFilter(JoinPoint joinPoint){
        Object[] args = joinPoint.getArgs();
        Object arg = args[0];
        if(arg instanceof BaseVO){
            BaseVO baseVO = (BaseVO)arg;
            if(!StringUtils.isNotEmpty(baseVO.getUserId())){
                throw new AuthFilterException("用户id为空");
            }
        }
    }
}
