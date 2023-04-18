package IoC;

import annotion.Autowire;
import com.sun.xml.internal.ws.util.StringUtils;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.Map;
import java.util.Objects;

public class DIExecute {
    public static void doDI() throws Exception {
        final Map beanMap = BeanFactory.beanMap;
        if(beanMap == null || beanMap.isEmpty()) {
            System.out.println("Bean Map is Empty");
            return;
        }
        for(Object bean : beanMap.values()) {
            Class<?> clazz = bean.getClass();
            Field[] declaredFields = clazz.getDeclaredFields();
            for(Field field:declaredFields) {
                Autowire autowire = field.getAnnotation(Autowire.class);
                if(autowire == null) {
                    continue;
                }
                field.setAccessible(true);
                Class<?> fieldClass = field.getType();
                Map<String, Object> objectMap = BeanFactory.getObjectMapByClass(fieldClass);
                if(objectMap.size() == 0) {
                    throw new Exception(fieldClass.getName() + " Bean not found!");
                }
                if(objectMap.size() == 1) {
                    field.set(bean, objectMap.values().iterator().next());
                    continue;
                }
                String fieldName = autowire.name();
                if(fieldName.isEmpty()) {
                    fieldName = field.getName();
                }
                boolean match = false;
                for(String beanName : objectMap.keySet()) {
                    if(Objects.equals(beanName, fieldName)) {
                        field.set(bean, objectMap.get(beanName));
                        match = true;
                        continue;
                    }
                }
                if(match) {
                    continue;
                }
                throw new Exception("multi Bean Has Bean Registed!");
            }
        }
    }
}
