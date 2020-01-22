package be.syntra.java.advanced.springmvc.vehicle;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;

import javax.validation.constraints.*;
import java.time.LocalDate;

@Data
public class Vehicle {
    @NotBlank(message = "{form.field.required}")
    private String brand;

    @NotBlank(message = "{form.field.required}")
    private String type;

    @NotNull(message = "{form.field.required}")
    private FuelType fuelType;

    @Min(value = 1970, message = "{form.field.vehicle.year} {value}")
    private int year;

    @Positive(message = "{form.field.vehicle.power}")
    private int power;

    @NotNull(message = "{form.field.required}")
    private TransmissionType transmission;

    @NotNull(message = "{form.field.required}")
    @FutureOrPresent(message = "{form.field.vehicle.entryIntoService}")
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private LocalDate entryIntoService;

    @Pattern(regexp = "\\d-[A-Z]{3}-\\d{3}", message = "{form.field.vehicle.plate}")
    @NotBlank(message = "{form.field.required}")
    private String plate;

    @Positive(message = "{form.field.vehicle.listPrice}")
    @Digits(integer = 7, fraction = 2, message = "{form.field.vehicle.listPrice.digits")
    @NumberFormat(style = NumberFormat.Style.NUMBER)
    private float listPrice;

    private boolean towBar;
    private String[] options;
}
