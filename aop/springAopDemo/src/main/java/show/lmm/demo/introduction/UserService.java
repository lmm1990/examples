package show.lmm.demo.introduction;

import org.springframework.stereotype.Component;

/**
 * 用户service
 *
 * @author lmm
 * @date 2022-03-23
 */
@Component
public class UserService implements Service{

    @Override
    public void test(){
        System.out.println("test");
    }
}
