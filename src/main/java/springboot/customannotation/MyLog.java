package springboot.customannotation;

import java.lang.annotation.*;

/**
 * @Date: 2019/2/18 10:12
 * @Description:
 * @Author admin
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MyLog {

    String value();

    String desc() default "打印日志";

}
