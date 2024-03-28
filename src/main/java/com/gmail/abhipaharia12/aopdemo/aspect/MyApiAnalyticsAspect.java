package com.gmail.abhipaharia12.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(3)
public class MyApiAnalyticsAspect {

    @Before("com.gmail.abhipaharia12.aopdemo.aspect.LuvAopExpressions.forDaoPackageNoGetterSetter()")
    public void performApiAnalytics() {
        System.out.println("\n=====>>> Performing API analytics");
    }
}
