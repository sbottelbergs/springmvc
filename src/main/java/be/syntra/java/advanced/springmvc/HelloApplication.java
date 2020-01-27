package be.syntra.java.advanced.springmvc;

import be.syntra.java.advanced.springmvc.restclient.MessagesClient;
import be.syntra.java.advanced.springmvc.restclient.model.Message;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class HelloApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = SpringApplication.run(HelloApplication.class, args);
        MessagesClient client = ctx.getBean(MessagesClient.class);
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
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

}
