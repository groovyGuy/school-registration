package com.school.registration.config;

import com.school.registration.service.AutofillRegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

@Configuration
public class AppConfig {
    @Autowired
    AutofillRegistrationService autofillRegistrationService;


    // Easiest way to trigger a spring bean (autofill service) after spring context is initialized
    @Bean
    @DependsOn("autofillRegistrationService")
    public String runTimeTrigger() {
        autofillRegistrationService.startAutofill();
        return "Success";
    }
    
}
