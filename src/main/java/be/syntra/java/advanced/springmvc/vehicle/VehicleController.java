package be.syntra.java.advanced.springmvc.vehicle;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/vehicle")
public class VehicleController {

    @ModelAttribute("options")
    public String[] getOptions() {
        return new String[]{"Alarm", "Handsfree carkit", "MP3 player", "Sports pack"};
    }

    @GetMapping
    public String redirect() {
        return "redirect:/vehicle/register";
    }

    @GetMapping("/register")
    public String handleGetRegister(@ModelAttribute("vehicle") Vehicle vehicle) {
        return "vehicle/vehicleForm";
    }

    @PostMapping("/register")
    public String registerVehicle(@Valid @ModelAttribute("vehicle") Vehicle vehicle, BindingResult br) {
        if (br.hasErrors()) {
            return "vehicle/vehicleForm";
        }

        return "vehicle/vehicleConfirm";
    }
}
