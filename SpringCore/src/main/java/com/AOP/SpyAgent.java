package com.AOP;

import java.util.ArrayList;
import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Aspect
@EnableAspectJAutoProxy
public class SpyAgent {

/*	@After("execution(* getListAddress())")
	public void printGetAddress(JoinPoint jp){
		System.out.println("after getAddress "+jp.getSignature());
	}*/
	
	@Around("execution(* com.Beans.PersonBean.getListAddress())")
	public Object printSetData(ProceedingJoinPoint jp) throws Throwable{
		ArrayList<String> dataList=(ArrayList<String>) jp.proceed();
		System.out.println("data og ="+dataList);
		if(null!=dataList)dataList.add("spy value");
		return dataList;
	}
}
