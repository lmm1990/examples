package show.lmm.demo.targetSource;

import org.springframework.aop.TargetSource;
import org.springframework.aop.framework.ProxyFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 被代理对象config
 *
 * @author lmm
 * @date 2022-03-23
 */
@Configuration
public class TargetSourceConfig {

    @Bean
    public UserService userService(){
        TargetSource targetSource = new TargetSource() {
            @Override
            public Class<?> getTargetClass() {
                return UserService.class;
            }

            @Override
            public boolean isStatic() {
                return false;
            }

            @Override
            public Object getTarget() throws Exception {
                return new UserService("张三");
            }

            @Override
            public void releaseTarget(Object target) throws Exception {
                //对象池需要处理
            }
        };

        ProxyFactoryBean proxyFactoryBean = new ProxyFactoryBean();
        proxyFactoryBean.setTargetSource(targetSource);
        return (UserService) proxyFactoryBean.getObject();
    }
}
