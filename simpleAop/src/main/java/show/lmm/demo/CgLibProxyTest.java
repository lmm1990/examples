package show.lmm.demo;

import net.sf.cglib.proxy.*;

/**
 * cglib动态代理测试
 *
 * @author lmm
 * @date 2022-03-23
 */
public class CgLibProxyTest {

    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(UserService.class);
        enhancer.setCallbacks(new Callback[]{
                (MethodInterceptor) (obj, method, args1, proxy) -> {
                    System.out.println("before");
                    Object value = proxy.invokeSuper(obj, args1);
                    System.out.println("after");
                    return value;
                }, NoOp.INSTANCE
        });
        //cjlib callback 过滤
        enhancer.setCallbackFilter(method -> {
            //test方法使用第一个callback，其他方法使用第二个callback
            if("test".equals(method.getName())){
                return 0;
            }
            return 1;
        });
        UserService userService = (UserService)enhancer.create();
        userService.test();
        System.out.println("--------------------------------------");
        userService.run();
    }
}
