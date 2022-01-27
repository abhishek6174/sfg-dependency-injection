package om.eternal.sfgdi.services;

import om.eternal.sfgdi.repositories.EnglishGreetingRepository;

public class I18nEnglishGreetingService implements GreetingService{
    private final EnglishGreetingRepository englishGreetingRepository;

    public I18nEnglishGreetingService(EnglishGreetingRepository englishGreetingRepository) {
        this.englishGreetingRepository = englishGreetingRepository;
    }


    @Override
    public String sayHello() {
        return "Hello World-EN";
    }
}
