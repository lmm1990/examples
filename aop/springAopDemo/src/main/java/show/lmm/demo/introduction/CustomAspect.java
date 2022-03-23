package show.lmm.demo.introduction;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareParents;
import org.springframework.stereotype.Component;

/**
 * 自定义切面
 *
 * @author lmm
 * @date 2022-03-23
 */
@Aspect
@Component
public class CustomAspect {

    @DeclareParents(value = "show.lmm.demo.introduction.UserService",defaultImpl = ExtendImpl.class)
    public ExtendInterface extendService;
}
