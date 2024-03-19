package com.luv2code.springboot.demo.mycoolapp.common;

// import org.springframework.beans.factory.config.ConfigurableBeanFactory;
// import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

// // For prototype scope for different instances  
// @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Component
public class CricketCoach implements Coach{

    // // define our init method
    // @PostConstruct
    // public void doMyStartupStuff() {
    //     System.out.println("In doMyStartupStuff(): " + getClass().getSimpleName());
    // }

    // // define our destroy method
    // @PreDestroy
    // public void doMyCleanupStuff() {
    //     System.out.println("In doMyCleanupStuff(): " + getClass().getSimpleName());
    // }

    @Override
    public String getDailyWorkout() {
        return "Practice fast bowling for 15 minutes";
    }

}
