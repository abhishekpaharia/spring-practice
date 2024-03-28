package com.gmail.abhipaharia12.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class LuvAopExpressions {

     @Pointcut("execution(* com.gmail.abhipaharia12.aopdemo.dao.*.*(..))")
    public void forDaoPackage(){}

    @Pointcut("execution(* com.gmail.abhipaharia12.aopdemo.dao.*.set*(..))")
    public void setter(){}

    @Pointcut("execution(* com.gmail.abhipaharia12.aopdemo.dao.*.get*(..))")
    public void getter(){}


    @Pointcut("forDaoPackage() && !(setter() || getter())")
    public void forDaoPackageNoGetterSetter() {}
}
