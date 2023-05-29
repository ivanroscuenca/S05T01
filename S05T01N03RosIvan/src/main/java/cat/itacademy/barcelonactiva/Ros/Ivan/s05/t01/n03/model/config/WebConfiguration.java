package cat.itacademy.barcelonactiva.Ros.Ivan.s05.t01.n03.model.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;
@Configuration
public class WebConfiguration {

    //Using WebClient
    @Bean
    public WebClient webClient(){
        return WebClient.builder()
                .baseUrl("http:localhost:9001")
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .build();
    }
}
