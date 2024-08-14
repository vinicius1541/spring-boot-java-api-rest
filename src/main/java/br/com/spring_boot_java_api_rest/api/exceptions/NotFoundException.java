package br.com.spring_boot_java_api_rest.api.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.Serial;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class NotFoundException extends HttpRuntimeException {
    @Serial
    private static final long serialVersionUID = 5L;

    private static final String RESOURCE_NOT_FOUND_MESSAGE = "Server could not find %s with %s: %s";

    public NotFoundException(String label) {
        super(String.format("Server couldn't find %s", label), HttpStatus.NOT_FOUND);
    }

    public NotFoundException(String label, String id) {
        this(label, "The ID", id);
    }

    public NotFoundException(String label, String field, String id) {
        super(String.format(RESOURCE_NOT_FOUND_MESSAGE, label, field, id), HttpStatus.NOT_FOUND);
    }

}
