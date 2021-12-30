package om.eternal.sfgdi.controller;

import om.eternal.sfgdi.services.GreetingService;
import om.eternal.sfgdi.services.GreetingServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class PropertyInjectedController {
    @Autowired
    public GreetingService greetingService;

    public String getGreeting(){
        return greetingService.sayHello();
//        greetingService = new GreetingServiceImpl();
//        greetingService.sayHello();
    }
}
