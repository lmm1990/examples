package show.lmm.demo.advice;


import org.aopalliance.intercept.MethodInvocation;
import org.aopalliance.intercept.MethodInterceptor;

/**
 * 抛出异常之后执行
 *
 * @author lmm
 * @date 2022-03-23
 */
public class CustomAfterThrowingAdvice implements MethodInterceptor {
    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        try{
            return invocation.proceed();
        }catch (Exception e){
            System.out.println("after throwing msg: "+e.getMessage());
            return null;
        }
    }
}
