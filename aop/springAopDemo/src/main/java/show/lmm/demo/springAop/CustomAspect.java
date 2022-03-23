package show.lmm.demo.springAop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * 自定义aop逻辑
 *
 * @author lmm
 * @date 2022-03-23
 */
@Aspect
@Component
public class CustomAspect {

    @Before("execution(public void show.lmm.demo.springAop.UserService.test())")
    public void before(JoinPoint joinPoint){
        System.out.println("before");
    }
}
