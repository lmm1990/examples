package show.lmm.demo.defaultAdvisorAutoProxy;

import org.springframework.stereotype.Component;

/**
 * 用户service
 *
 * @author lmm
 * @date 2022-03-23
 */
@Component
public class UserService {

    public void test(){
        System.out.println("test");
    }

    public void run(){
        System.out.println("run");
    }
}
