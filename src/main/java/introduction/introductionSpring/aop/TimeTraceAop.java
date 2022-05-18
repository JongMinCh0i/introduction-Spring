package introduction.introductionSpring.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TimeTraceAop {

    //  @Around("execution(* introduction.introductionSpring..*(..))") introduction.introductionSpring 하위 전부 적용
    //  @Around("execution(* introduction.introductionSpring.service..*(..))") introduction.introductionSpring.service 하위 전부 적용

    @Around("execution(* introduction.introductionSpring..*(..))")
    public Object execute(ProceedingJoinPoint joinPoint) throws Throwable {

        long start = System.currentTimeMillis();

        System.out.println("START: " + joinPoint.toString());

        try {
            return joinPoint.proceed();
        } finally {
            long finish = System.currentTimeMillis();
            long timeMs = finish - start;
            System.out.println("END: " + joinPoint.toString() + " " + timeMs + "ms");
        }
    }
}