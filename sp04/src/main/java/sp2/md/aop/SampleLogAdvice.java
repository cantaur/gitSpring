package sp2.md.aop;

import lombok.extern.log4j.Log4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Log4j
@Aspect
@Component
public class SampleLogAdvice { //Aspect 지시해주는 클래스, 지시대상이 되는 클래스는 서비스에 생성
    //이 패키지의 메소드들이 수행되기 전에 log를 찍으라는 메소드
    @Before("execution(* sp2.md.service.SampleLogService*.*(..))")
    public void logBefore() {
        log.info("#(3)logBefore() 수행");
    }

    //이 패키지의 메소드들이 실행할 때 앞뒤로 log를 찍으라는 메소드
    @Around("execution(* sp2.md.service.SampleLogService*.*(..))")
    public Object logTime(ProceedingJoinPoint pjp) throws Throwable {
        long start = System.currentTimeMillis();

        //로직 시작
        //타겟클래스가 무엇인지
        log.info("#(1)target class: " + pjp.getTarget().getClass());
        log.info("#(2)args: " + Arrays.deepToString(pjp.getArgs()));

        Object result = null;
        try {
            result = pjp.proceed(); //비지니스 메소드로 진행하도록 하는 메소드
        }catch(Throwable t) {
        	log.info("#예외 발생  t: " + t);
        }
        long end = System.currentTimeMillis();
        log.info("#(4)수행시간: " + ( end-start));

        return result;
    }

    @After("execution(* sp2.md.service.SampleLogService*.*(..))")
    public void logAfter() {
        log.info("#(5)logAfter() 수행");
    }
    @AfterThrowing(pointcut = "execution(* sp2.md.service.SampleLogService*.*(..))", throwing = "exception")
    public void logAfterThrowing(Exception exception) {
        log.info("#(5)logAfterThrowing exception: " + exception);
    }


}
