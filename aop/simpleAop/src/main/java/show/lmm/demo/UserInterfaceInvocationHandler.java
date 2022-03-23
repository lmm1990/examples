package show.lmm.demo;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 描述
 *
 * @author lmm
 * @date 2022-03-23
 */
public class UserInterfaceInvocationHandler implements InvocationHandler {

    private UserInterface userInterface;

    public UserInterfaceInvocationHandler(UserInterface userInterface){
        this.userInterface = userInterface;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("before");
        Object value = method.invoke(userInterface, args);
        System.out.println("after");
        return value;
    }
}
