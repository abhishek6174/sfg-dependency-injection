package om.eternal.sfgdi;

import om.eternal.sfgdi.controller.ConstructorInjectedController;
import om.eternal.sfgdi.controller.MyController;
import om.eternal.sfgdi.controller.PropertyInjectedController;
import om.eternal.sfgdi.controller.SetterInjectedController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SfgDiApplication {

	public static void main(String[] args) {
		ApplicationContext applicationContext = SpringApplication.run(SfgDiApplication.class, args);

		MyController myController = (MyController) applicationContext.getBean("myController");
		System.out.println("Primary Bean----");
		String hello = myController.sayGreeting();
		System.out.println(hello);

		System.out.println("Property------");

		PropertyInjectedController propertyInjectedController =
				(PropertyInjectedController) applicationContext.getBean("propertyInjectedController");
		System.out.println(propertyInjectedController.getGreeting());

		System.out.println("Setter--------");
		SetterInjectedController setterInjectedController =
				(SetterInjectedController) applicationContext.getBean("setterInjectedController");
		System.out.println(setterInjectedController.getGreeting());
		System.out.println("Constructor-----");
		ConstructorInjectedController constructorInjectedController =
				(ConstructorInjectedController) applicationContext.getBean("constructorInjectedController");
		System.out.println(constructorInjectedController.getGreeting());
	}

}
