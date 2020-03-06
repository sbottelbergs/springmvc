package be.syntra.java.advanced.springmvc;

import be.syntra.java.advanced.springmvc.messages.MessagesFeignClient;
import be.syntra.java.advanced.springmvc.messages.model.Message;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
@EnableFeignClients
public class HelloApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = SpringApplication.run(HelloApplication.class, args);
//        MessagesClient client = ctx.getBean(MessagesClient.class);
//        MessagesClient client = ctx.getBean("messagesWebClient", MessagesClient.class);
        MessagesFeignClient client = ctx.getBean(MessagesFeignClient.class);
        Message message = client.getMessageById(1);
        System.out.println(message.getText());
    }

    @Bean
    public WebMvcConfigurer configurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addViewControllers(ViewControllerRegistry registry) {
                registry.addViewController("/welcome").setViewName("welcome");
                registry.addViewController("/customer/customerdetail").setViewName("customer/customerdetail");
                registry.addViewController("/address/addressdetail").setViewName("address/addressdetail");
                registry.addViewController("/bootstrap").setViewName("bootstrap/bootstrap");
                registry.addViewController("/materialize").setViewName("materialize/materialize");
            }
        };
    }

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder restTemplateBuilder, @Value("${baseUrl}") String baseUrl) {
        return restTemplateBuilder
                .basicAuthentication("homer", "password")
                .rootUri(baseUrl)
                .build();
    }

    @Bean
    public WebClient webClient(@Value("${baseUrl}") String baseUrl) {
        return WebClient.builder()
                .baseUrl(baseUrl)
                .build();
    }

}
