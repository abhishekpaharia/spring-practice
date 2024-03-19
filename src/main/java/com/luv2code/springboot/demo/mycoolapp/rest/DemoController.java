package com.luv2code.springboot.demo.mycoolapp.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luv2code.springboot.demo.mycoolapp.common.Coach;

@RestController
public class DemoController {
    private Coach myCoach;

    // // primary coach will be injected 
    // @Autowired
    // DemoController(Coach coach){
    //     myCoach = coach;
    // }

    // // same or different instance depending upon scope of beans 
    // @Autowired
    // DemoController(@Qualifier("cricketCoach")Coach theCoach, @Qualifier("cricketCoach") Coach theAnotherCoach){
    //     System.out.println("In constructor: " + getClass().getSimpleName());
    //     myCoach = theCoach;
    //     anotherCoach = theAnotherCoach;
    // }

    @Autowired
    DemoController(@Qualifier("aquatic")Coach theCoach){
        System.out.println("In constructor: " + getClass().getSimpleName());
        myCoach = theCoach;
    }

    @GetMapping("/")
    public String home(){
        return "home";
    }

    @GetMapping("/dailyworkout")
    public String getDailyWorkout() {
        return myCoach.getDailyWorkout();
    }

    // @GetMapping("/check")
    // public String check() {
    //     return "Comparing beans: myCoach == anotherCoach, " + (myCoach == anotherCoach);
    // }
}
