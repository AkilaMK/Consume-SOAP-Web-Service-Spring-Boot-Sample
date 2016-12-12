package com.example.conf;

import com.example.service.PersonServiceClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

/**
 * Created by akila on 12/11/16.
 */
@Configuration
public class WebServiceConfig {
    @Bean
    public Jaxb2Marshaller marshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setContextPath("com.example.gen");
        return marshaller;
    }

    @Bean
    public PersonServiceClient weatherClient(Jaxb2Marshaller marshaller) {

        PersonServiceClient client = new PersonServiceClient();

        client.setDefaultUri("http://ws.cdyne.com/WeatherWS");
        client.setMarshaller(marshaller);
        client.setUnmarshaller(marshaller);
        return client;
    }
}
