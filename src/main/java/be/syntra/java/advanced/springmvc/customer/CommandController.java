package be.syntra.java.advanced.springmvc.customer;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/customer")
public class CommandController {

    @GetMapping
    public String forward() {
        return "customer/customerform";
    }

    @PostMapping
    public String processForm(@ModelAttribute("data") Customer cust) {
        System.out.println(cust.getFirstName());
        System.out.println(cust.getLastName());
        System.out.println(cust.getEmail());
        return "customer/customerdetail";
    }
}
