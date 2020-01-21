package be.syntra.java.advanced.springmvc.form;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import javax.validation.constraints.Size;

@Controller
@RequestMapping("/inputForm")
public class FormController {

    @ModelAttribute("choiceList")
    public String[] getCheckboxes() {
        return new String[]{"First Choice", "Second Choice", "Third Choice"};
    }

    @ModelAttribute("radioList")
    public String[] getRadiolist() {
        return new String[]{"Radio 1", "Radio 2", "Radio 3"};
    }

    @GetMapping
    public String forward(@ModelAttribute("myform") FormCommand form) {
        return "forms/inputForm";
    }

    @PostMapping
    public String handleForm(@Valid @ModelAttribute("myform") FormCommand form, BindingResult br) {
        if (br.hasErrors()) {
            for (String code : br.getFieldError().getCodes()) {
                System.out.println(code);
            }
            System.out.println("error");
            return "forms/inputForm";
        }

        return "forms/nextPage";
    }

}
