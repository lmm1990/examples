package show.lmm.demo;

/**
 * 用户service
 *
 * @author lmm
 * @date 2022-03-23
 */
public class UserService {

    public void test(){
        System.out.println("test");
    }

    public void testThrowing(){
        throw new RuntimeException("testThrowing");
    }

    public void run(){
        System.out.println("run");
    }
}
