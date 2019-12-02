package com.shengxi.compent.aop.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 登录状态验证
 *
 * @author matthew
 * @version 1.0.0
 * @date 2019-11-26 12:29:20
 * @see java.lang.annotation.Annotation
 */

@Documented
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface LoginStatus {
    boolean value() default false;
}
