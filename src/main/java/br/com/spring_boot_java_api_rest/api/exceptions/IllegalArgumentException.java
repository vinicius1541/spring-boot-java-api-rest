package br.com.spring_boot_java_api_rest.api.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.Serial;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class IllegalArgumentException extends RuntimeException {
    @Serial
    private static final long serialVersionUID = 1L;

    public IllegalArgumentException(String message) {
        super(message);
    }
}
