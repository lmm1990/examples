package show.lmm.validation.core.annotation.validator.validation;

import show.lmm.validation.core.annotation.validator.StartWithValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.PARAMETER;

/**
 * 字符串必须以prefix开头
 */
@Documented
@Target({PARAMETER, FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {StartWithValidator.class})
public @interface StartsWith {

    /**
     * 前缀
     */
    String prefix();

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    String message() default "";
}
