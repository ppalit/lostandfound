package com.lostandfound.services.exception;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class AspectHandler {

	@Around("execution(* com.lostandfound.services.dao.*.*(..))")
	public Object handleDaoException(ProceedingJoinPoint aJoinPoint)
			throws Throwable {
		try {

			System.out.println("Entering "
					+ aJoinPoint.getSignature().getDeclaringTypeName() + ":"
					+ aJoinPoint.getSignature().getName());
			Object returnArg = aJoinPoint.proceed();
			System.out.println("Exiting "
					+ aJoinPoint.getSignature().getDeclaringTypeName() + ":"
					+ aJoinPoint.getSignature().getName());
			return returnArg;
		} catch (Exception exp) {
			System.out.println("error in DAO :"
					+ exp);
			throw new CustomGenericException("BUSINESS-SERVICES-ERR1", "Error in DB interaction.. check logs for more details");
		}
	}
	
	@Around("execution(* com.lostandfound.services.processor.*.*(..))")
	public Object handleProcessorException(ProceedingJoinPoint aJoinPoint)
			throws Throwable {
		try {

			System.out.println("Entering "
					+ aJoinPoint.getSignature().getDeclaringTypeName() + ":"
					+ aJoinPoint.getSignature().getName());
			Object returnArg = aJoinPoint.proceed();
			System.out.println("Exiting "
					+ aJoinPoint.getSignature().getDeclaringTypeName() + ":"
					+ aJoinPoint.getSignature().getName());
			return returnArg;
		}
		catch (Exception exp) {
			if (exp.getCause() instanceof CustomGenericException){
				throw exp;
			}
			System.out.println("error in processor  :"
					+ exp);
			throw new CustomGenericException("BUSINESS-SERVICES-ERR2", "Error in Processor interaction.. check logs for more details");
		}
	}

}
