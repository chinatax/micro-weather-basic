package cn.chinatax.microweatherbasic.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @Author Tigger
 * @ClassName RestConfiguration
 * @Description //TODO
 * @Date
 * @Version 1.0
 **/
@Configuration
public class RestConfiguration {

    @Autowired
    private RestTemplateBuilder builder;

    @Bean
    public RestTemplate restTemplate(){

        return builder.build();
    }
}
