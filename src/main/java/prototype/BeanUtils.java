package prototype;

import java.lang.reflect.Field;

public class BeanUtils {

    public static Object copy(Object t) {
        Class<?> aClass = t.getClass();
        Field[] declaredFields = aClass.getDeclaredFields();
        Object resultValue = null;
        try {
            resultValue = aClass.newInstance();
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
        for(Field f : declaredFields) {
            try {
                f.setAccessible(true);
                f.set(resultValue, f.get(t));
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }
        return resultValue;
    }

    public static void copy(Object target, Object src) {
        Class<?> aClass = src.getClass();
        Field[] declaredFields = aClass.getDeclaredFields();

        for(Field f : declaredFields) {
            f.setAccessible(true);
            try {
                f.set(target, f.get(src));
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }
    }

}
