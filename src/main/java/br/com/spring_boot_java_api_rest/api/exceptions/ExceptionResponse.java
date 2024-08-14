package br.com.spring_boot_java_api_rest.api.exceptions;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ExceptionResponse {
    private String timestamp;
    private int status;
    private String error;
    private String message;
    private String path;
}
