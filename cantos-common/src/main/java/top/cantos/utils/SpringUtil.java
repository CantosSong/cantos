package top.cantos.utils;

import org.springframework.context.ApplicationContext;

/**
 * Created by Tibers on 17/3/10.
 */
public class SpringUtil {
    private static ApplicationContext content;

    public SpringUtil() {
    }

    public static void setContent(ApplicationContext content) {
        SpringUtil.content = content;
    }
    public static Object getBean(String beanName) {
        return content.getBean(beanName);
    }
    public static <T>  T getBean(Class<T> clasName) {
        return content.getBean(clasName);
    }
}
