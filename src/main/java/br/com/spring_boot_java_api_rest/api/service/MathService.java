package br.com.spring_boot_java_api_rest.api.service;

import br.com.spring_boot_java_api_rest.api.exceptions.UnsupportedMathOperationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class MathService {
    private static final Logger logger = LoggerFactory.getLogger(MathService.class);
    public Double parseDoubleConverter(String str) {
        String numberFormatted = str.replace(",", ".");

        if ( !isNumeric(numberFormatted) ) {
            throw new UnsupportedMathOperationException("Input inválido: " + numberFormatted);
        }

        return Double.parseDouble(numberFormatted);
    }

    public boolean isNumeric(String str) {
        return !str.isBlank() && str.matches("-?\\d+(\\.\\d+)?");
    }
}
