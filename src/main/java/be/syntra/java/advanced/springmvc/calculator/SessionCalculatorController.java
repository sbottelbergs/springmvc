package be.syntra.java.advanced.springmvc.calculator;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.annotation.SessionScope;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/calc/advanced")
@SessionScope
public class SessionCalculatorController {

    private static final String ADD = "+";
    private static final String SUBTRACT = "-";
    private static final String MULTIPLY = "*";
    private static final String DIVIDE = "/";
    private static final String CLEAR = "C";

    private String[] operations = {ADD, SUBTRACT, MULTIPLY, DIVIDE, CLEAR};

    private double result;

    @ModelAttribute("operations")
    public String[] operations() {
        return operations;
    }

    @GetMapping
    public ModelAndView handleGet() {
        return getModelAndView();
    }

    @PostMapping
    public ModelAndView handlePost(@RequestParam String action, @RequestParam(required = false) Double value) {
        if (action.equals(CLEAR)) {
            result = 0;
        } else if (value != null) {
            switch (action) {
                case ADD:
                    result += value;
                    break;
                case SUBTRACT:
                    result -= value;
                    break;
                case MULTIPLY:
                    result *= value;
                    break;
                case DIVIDE:
                    result /= value;
                    break;
            }
        }
        return getModelAndView();
    }

    private ModelAndView getModelAndView() {
        return new ModelAndView("calc/advanced", "result", result);
    }

}
