package com.woopay.membership.common;

import org.springframework.core.annotation.AliasFor;
import org.springframework.stereotype.Component;

import java.lang.annotation.*;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Component
public @interface UseCase {

    // 빈 이름 직접 지정하고 싶을 때
    @AliasFor(annotation = Component.class)
    String value() default "";
}
