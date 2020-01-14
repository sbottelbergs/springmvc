package be.syntra.java.advanced.springmvc.calculator;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/calc")
public class CalculatorController {

    @PostMapping()
    public ModelAndView handleSum(@RequestParam int first_number, @RequestParam int second_number) {
        return new ModelAndView("/calc/calc", "sum", first_number + second_number);
    }

    @GetMapping
    public String handleGet() {
        return "/calc/calc";
    }
}
