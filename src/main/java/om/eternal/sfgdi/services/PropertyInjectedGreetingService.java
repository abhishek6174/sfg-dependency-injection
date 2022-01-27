package om.eternal.sfgdi.services;

import org.springframework.stereotype.Service;

//@Service
public class PropertyInjectedGreetingService implements GreetingService{
    @Override
    public String sayHello() {
        return "Hello from Property Injected Service";
    }
}
