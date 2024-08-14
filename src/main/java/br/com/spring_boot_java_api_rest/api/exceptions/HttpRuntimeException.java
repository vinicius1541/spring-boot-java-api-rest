package br.com.spring_boot_java_api_rest.api.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.io.Serial;

@Getter
@AllArgsConstructor
public class HttpRuntimeException extends RuntimeException {
    @Serial
    private static final long serialVersionUID = 3L;

    private final HttpStatus httpStatus;

    public HttpRuntimeException(String message, HttpStatus httpStatus) {
        super(message);
        this.httpStatus = httpStatus;
    }
}
