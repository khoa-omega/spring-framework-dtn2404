package com.vti.blog_app.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = PostIdExistsValidator.class)
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface PostIdExists {
    String message() default "Bài viết không tồn tại";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
