package show.lmm.demo.targetSource;

import org.springframework.stereotype.Component;

/**
 * 用户service
 *
 * @author lmm
 * @date 2022-03-23
 */
@Component
public class UserService {

    private String userName;

    public UserService(String userName){
        this.userName = userName;
    }

    public void test(){
        System.out.println("test "+userName);
    }
}
