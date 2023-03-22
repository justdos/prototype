package myAnnoition;

import java.lang.annotation.*;

@Target({ElementType.METHOD, ElementType.FIELD, ElementType.TYPE, ElementType.CONSTRUCTOR} )
@Retention(RetentionPolicy.RUNTIME)
public @interface BizDao {
    boolean print();
}
