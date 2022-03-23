package show.lmm.demo;

import java.lang.reflect.Proxy;

/**
 * jdk动态代理测试
 *
 * @author lmm
 * @date 2022-03-23
 */
public class JdkProxyTest {

    public static void main(String[] args) {
        UserInterface userInterfaceBase = new UserService();
        UserInterfaceInvocationHandler userInterfaceInvocationHandler = new UserInterfaceInvocationHandler(userInterfaceBase);
        UserInterface userInterface = (UserInterface) Proxy.newProxyInstance(JdkProxyTest.class.getClassLoader(), new Class[]{UserInterface.class}, userInterfaceInvocationHandler);
        userInterface.test();
    }
}
