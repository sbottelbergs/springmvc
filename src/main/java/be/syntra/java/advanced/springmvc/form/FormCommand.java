package be.syntra.java.advanced.springmvc.form;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Data
public class FormCommand implements Serializable {
    private String[] choices;

    @NotBlank
    private String message;
}
