package show.lmm.demo.advice;

import org.springframework.aop.AfterReturningAdvice;

import java.lang.reflect.Method;

/**
 * 方法执行之后执行
 *
 * @author lmm
 * @date 2022-03-23
 */
public class CustomAfterReturningAdvice implements AfterReturningAdvice {
    @Override
    public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
        System.out.println("after returning");
    }
}
