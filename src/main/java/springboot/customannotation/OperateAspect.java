package springboot.customannotation;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * @Date: 2019/2/18 10:14
 * @Description:
 * @Author admin
 */
@Aspect
@Component
public class OperateAspect {

    @Pointcut("@annotation(springboot.customannotation.MyLog)")
    public void annotationPointCut() {

    }

    @Before("annotationPointCut()")
    public void before(JoinPoint joinPoint) {
        MethodSignature sign = (MethodSignature) joinPoint.getSignature();
        Method method = sign.getMethod();
        MyLog myLog = method.getAnnotation(MyLog.class);
        System.out.print("打印：" + myLog.value() + " 开始前");
    }

    @Around("annotationPointCut()")
    public Object advice(ProceedingJoinPoint proceedingJoinPoint) {
        System.out.println("环绕开始");
        Object msg = null;
        try {
            msg = proceedingJoinPoint.proceed();
            System.out.println("+++++++++++++++++:  "+msg);
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        System.out.println("通知结束");
        return msg;
    }

    @After("annotationPointCut()")
    public void after() {
        System.out.println("after之后");
    }


}
