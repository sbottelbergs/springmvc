package be.syntra.java.advanced.springmvc.form;

import lombok.Data;

import javax.validation.constraints.Size;
import java.io.Serializable;

@Data
public class FormCommand implements Serializable {
    private String[] choices;
    @Size(min = 1)
    private String message;
    private boolean selection;
    private String radioValue;
    private SizeType size;
}
