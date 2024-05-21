package com.mi.usermanagement.anno;

import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.ReportAsSingleViolation;
import javax.validation.constraints.NotBlank;
import java.lang.annotation.*;

@NotBlank(message = "密码不能为空")
@ReportAsSingleViolation
@Constraint(validatedBy = {})
@Documented
@Target({ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface NotEmptyString {
    String message() default "密码不能为空";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
