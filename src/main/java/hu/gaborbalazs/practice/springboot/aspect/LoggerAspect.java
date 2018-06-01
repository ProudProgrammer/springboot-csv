package hu.gaborbalazs.practice.springboot.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class LoggerAspect {

	private static final String BEFORE = ">> ";
	private static final String AFTER = "<< ";
	private static final String BRACKET = "()";

	@Pointcut("within(hu.gaborbalazs.practice.springboot.rest..*)")
	private void restMethods() {
	}

	@Pointcut("within(hu.gaborbalazs.practice.springboot.data..*)")
	private void dataMethods() {
	}

	@Around("restMethods() || dataMethods()")
	public Object aroundRestOrDataMethods(ProceedingJoinPoint joinPoint) throws Throwable {
		Logger logger = LoggerFactory.getLogger(joinPoint.getTarget().getClass());
		logger.debug(BEFORE + joinPoint.getSignature().getName() + BRACKET);
		Object retval = joinPoint.proceed();
		logger.debug(AFTER + joinPoint.getSignature().getName() + BRACKET);
		return retval;
	}

}
