package om.eternal.sfgdi.config;


import om.eternal.pets.PetService;
import om.eternal.pets.PetServiceFactory;
import om.eternal.sfgdi.datasource.FakeDataSource;
import om.eternal.sfgdi.repositories.EnglishGreetingRepository;
import om.eternal.sfgdi.repositories.EnglishGreetingRepositoryImpl;
import om.eternal.sfgdi.services.*;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.*;

/**
 * Created by jt on 2/20/21.
 */
//@PropertySource("classpath:datasource.properties")
@EnableConfigurationProperties(SfgConstructorConfig.class)
@ImportResource("classpath:sfgdi-config.xml")
@Configuration
public class GreetingServiceConfig {



    @Bean
//    FakeDataSource fakeDataSource(@Value("${guru.username}") String username,
//                                  @Value("${guru.password}")String password,
//                                  @Value("${guru.jdbcurl}") String jdbcurl){
    FakeDataSource fakeDataSource(SfgConstructorConfig sfgConstructorConfig){

        FakeDataSource fakeDataSource = new FakeDataSource();

        fakeDataSource.setUsername(sfgConstructorConfig.getUsername());//env variable one will override this one as guru.username == GURU_USERNAME
        fakeDataSource.setPassword(sfgConstructorConfig.getPassword());
        fakeDataSource.setJdbcurl(sfgConstructorConfig.getJdbcurl());

        return fakeDataSource;
    }

    @Bean
    PetServiceFactory petServiceFactory(){
        return new PetServiceFactory();
    }

    @Profile({"dog", "default"})
    @Bean
    PetService dogPetService(PetServiceFactory petServiceFactory){
        return petServiceFactory.getPetService("dog");
    }

    @Bean
    @Profile("cat")
    PetService catPetService(PetServiceFactory petServiceFactory){
        return petServiceFactory.getPetService("cat");
    }

    @Profile({"ES", "default"})
    @Bean("i18nService")
    I18nSpanishGreetingService i18NSpanishService(){
        return new I18nSpanishGreetingService();
    }

    @Bean
    EnglishGreetingRepository englishGreetingRepository(){
        return new EnglishGreetingRepositoryImpl();
    }

    @Profile("EN")
    @Bean
    I18nEnglishGreetingService i18nService(EnglishGreetingRepository englishGreetingRepository){
        return new I18nEnglishGreetingService(englishGreetingRepository);
    }

    @Primary
    @Bean
    PrimaryGreetingService primaryGreetingService(){
        return new PrimaryGreetingService();
    }

    @Bean
    PropertyInjectedGreetingService propertyInjectedGreetingService(){
        return new PropertyInjectedGreetingService();
    }

    @Bean
    SetterInjectedGreetingService setterInjectedGreetingService(){
        return new SetterInjectedGreetingService();
    }
}
