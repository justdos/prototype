package annotion;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 配置类组件注解
 */
@Target({ElementType.TYPE} )
@Retention(RetentionPolicy.RUNTIME)
public @interface MyConfig {
    String scanPath() default "";
}
