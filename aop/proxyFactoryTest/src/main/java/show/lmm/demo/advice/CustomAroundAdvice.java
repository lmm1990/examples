package show.lmm.demo.advice;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * 方法执行前、后执行
 *
 * @author lmm
 * @date 2022-03-23
 */
public class CustomAroundAdvice implements MethodInterceptor {
    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        System.out.println("around before");
        Object value = invocation.proceed();
        System.out.println("around after");
        return value;
    }
}
