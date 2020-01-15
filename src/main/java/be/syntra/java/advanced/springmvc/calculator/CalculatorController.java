package be.syntra.java.advanced.springmvc.calculator;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/calc")
public class CalculatorController {

    //    @PostMapping
    @GetMapping(params = {"first_number", "second_number"})
    public ModelAndView handleSum(@RequestParam("first_number") int firstNumber,
                                  @RequestParam("second_number") int secondNumber) {
        return new ModelAndView("calc/calc", "sum", firstNumber + secondNumber);
    }

    @GetMapping
    public String handleGet() {
        return "calc/calc";
    }

//    @GetMapping
//    public ModelAndView handleSum(@RequestParam(value = "first_number", required = false) Integer firstNumber,
//                                  @RequestParam(value = "second_number", required = false) Integer secondNumber) {
//        if (firstNumber != null && secondNumber != null) {
//            return new ModelAndView("calc/calc", "sum", firstNumber + secondNumber);
//        } else {
//            return new ModelAndView("calc/calc");
//        }
//    }
}
