package show.lmm.validation.core.annotation.validator;

import show.lmm.validation.core.annotation.validator.validation.StartsWith;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class StartWithValidator implements ConstraintValidator<StartsWith, String> {

    StartsWith param;

    @Override
    public void initialize(StartsWith constraintAnnotation) {
        param = constraintAnnotation;
    }

    @Override
    public boolean isValid(String baseValue, ConstraintValidatorContext context) {
        return baseValue.startsWith(param.prefix());
    }
}
