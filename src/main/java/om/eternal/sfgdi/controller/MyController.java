package om.eternal.sfgdi.controller;

import org.springframework.stereotype.Controller;

@Controller
public class MyController {
    public String sayHello(){
        System.out.println("Inside sayHello!");
        return "Hi! Folks.";
    }
}
