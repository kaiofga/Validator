package br.com.aldar.web.annotation;

import javax.enterprise.util.Nonbinding;
import javax.interceptor.InterceptorBinding;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by Kaio on 01/05/17.
 * Annotation created to annotate the methods
 */
@InterceptorBinding
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.TYPE})
public @interface RoleValidator {
    @Nonbinding String[] deny() default "";

    @Nonbinding String[] allow() default "";
}