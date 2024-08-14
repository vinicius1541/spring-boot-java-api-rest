package br.com.spring_boot_java_api_rest.api.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.Serial;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class UnsupportedMathOperationException extends HttpRuntimeException {
    @Serial
    private static final long serialVersionUID = 1L;

    public UnsupportedMathOperationException(String message) {
        super(message, HttpStatus.BAD_REQUEST);
    }
}
