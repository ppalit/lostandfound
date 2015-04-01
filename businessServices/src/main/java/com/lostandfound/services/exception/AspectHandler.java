package com.lostandfound.services.exception;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Aspect
public class AspectHandler {
	
	Logger logger = LoggerFactory.getLogger(AspectHandler.class);

	@Around("execution(* com.lostandfound.services.dao.*.*(..))")
	public Object handleDaoException(ProceedingJoinPoint aJoinPoint)
			throws Throwable {
		try {

			logger.info("Entering "
					+ aJoinPoint.getSignature().getDeclaringTypeName() + ":"
					+ aJoinPoint.getSignature().getName());
			Object returnArg = aJoinPoint.proceed();
			logger.info("Exiting "
					+ aJoinPoint.getSignature().getDeclaringTypeName() + ":"
					+ aJoinPoint.getSignature().getName());
			return returnArg;
		} catch (Exception exp) {
			logger.error("error in DAO :"+ exp);
			throw new CustomGenericException("BUSINESS-SERVICES-ERR1", "Error in DB interaction.. check logs for more details");
		}
	}
	
	@Around("execution(* com.lostandfound.services.processor.*.*(..))")
	public Object handleProcessorException(ProceedingJoinPoint aJoinPoint)
			throws Throwable {
		try {

			logger.info("Entering "
					+ aJoinPoint.getSignature().getDeclaringTypeName() + ":"
					+ aJoinPoint.getSignature().getName());
			Object returnArg = aJoinPoint.proceed();
			logger.info("Exiting "
					+ aJoinPoint.getSignature().getDeclaringTypeName() + ":"
					+ aJoinPoint.getSignature().getName());
			return returnArg;
		}
		catch (Exception exp) {
			if (exp.getCause() instanceof CustomGenericException){
				throw exp;
			}
			logger.error("error in processor  :"+ exp);
			throw new CustomGenericException("BUSINESS-SERVICES-ERR2", "Error in Processor interaction.. check logs for more details");
		}
	}

}
