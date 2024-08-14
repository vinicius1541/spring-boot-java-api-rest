package br.com.spring_boot_java_api_rest.api.controller;

import br.com.spring_boot_java_api_rest.api.model.MathRequest;
import br.com.spring_boot_java_api_rest.api.service.MathService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/operators")
public class MathController{
    final MathService mathService;

    public MathController(MathService mathService) {
        this.mathService = mathService;
    }

    @PostMapping("/sum")
    public ResponseEntity<Double> sum(@Valid @RequestBody MathRequest mathRequest) throws IllegalArgumentException {
        Double result = mathService.parseDoubleConverter(mathRequest.getNumberOne()) +
                        mathService.parseDoubleConverter(mathRequest.getNumberTwo());

        return ResponseEntity.ok(result);
    }
}
