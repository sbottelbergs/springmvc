package be.syntra.java.advanced.springmvc.hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Controller
public class HelloController {

    private final HelloService helloService;

    @PostConstruct
    public void init() {
        System.out.println("HelloController: init()");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("HelloController: destroy()");
    }

    @Autowired
    public HelloController(HelloService helloService) {
        this.helloService = helloService;
    }

    @RequestMapping("/hello")
    public ModelAndView homePage() {
        String text = helloService.sayHello();
        return new ModelAndView("helloView", "message", text);
    }
}
