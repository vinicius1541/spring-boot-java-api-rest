package br.com.spring_boot_java_api_rest.api.model;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MathRequest {
    @NotBlank(message = "Number one can't be blank.")
    private String numberOne;
    @NotBlank(message = "Number two can't be blank.")
    private String numberTwo;
}
