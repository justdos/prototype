package annotion;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Bean定义注解
 */
@Target({ElementType.TYPE} )
@Retention(RetentionPolicy.RUNTIME)
public @interface MyBean {
    String alias() default "";
}
