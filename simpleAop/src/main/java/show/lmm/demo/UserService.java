package show.lmm.demo;

/**
 * 用户service
 *
 * @author lmm
 * @date 2022-03-23
 */
public class UserService implements UserInterface {

    @Override
    public void test(){
        System.out.println("test");
    }

    @Override
    public void run() {
        System.out.println("run");
    }
}
