package com.luv2code.springdemo.mvc;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;

@Controller
public class CustomerController {

    // add an initbinder ... to convert trim input strings
    // remove leading and trailing whitespace
    // resolve issue for our validation
    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {

        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);

        dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
        System.err.println("dataBinder target class: " + dataBinder.getTarget());
        System.err.println("dataBinder target validators: " + dataBinder.getValidator());
    }

    @GetMapping("/")
    public String showForm(Model theModel) {

        theModel.addAttribute("customer", new Customer());

        return "customer-form";
    }

    @PostMapping("/processForm")
    public String processForm(
            // @Valid @ModelAttribute("customer") Customer theCustomer2, // This coming form model
            // BindingResult theBindingResult2, // this bindingResult is corresponding to the customer2
            @Valid  Customer theCustomer, // this coming form request body or payload and content-type is application/x-www-form-urlencoded so we are nor using @RequestBody
            BindingResult theBindingResult // this bindingResult is corresponding to the customer
            ) {

        //System.out.println("firstName name:" + firstName);

        // System.out.println("Binding: " + theBindingResult.getTarget().toString());
        // System.out.println("Binding-model: " + theBindingResult.getModel());

        // System.out.println("Binding: " + theBindingResult2.getTarget().toString());
        // System.out.println("Binding-model: " + theBindingResult2.getModel());

        // System.out.println("Binding: " + theBindingResult3.getTarget().toString());
        // System.out.println("Binding-model: " + theBindingResult3.getModel());


        //System.out.println("Binding: " + theBindingResult.MODEL_KEY_PREFIX);
        //System.out.println("Binding2: " + theBindingResult.NESTED_PATH_SEPARATOR);
        
        System.out.println("\n\n\n\n");


        if (theBindingResult.hasErrors()) {
            return "customer-form";
        }
        else {
            return "customer-confirmation";
        }
        //return "customer-form";
    }
}







