package be.syntra.java.advanced.springmvc.address;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/address")
public class AddressController {

    @GetMapping
    public String showForm() {
        return "address/addressform";
    }

    @PostMapping
    public String processForm(Address address) {
        return "address/addressdetail";
    }

}
