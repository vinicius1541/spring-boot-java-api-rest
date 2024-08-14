package br.com.spring_boot_java_api_rest.api.exceptions.handler;

import br.com.spring_boot_java_api_rest.api.exceptions.ExceptionResponse;
import br.com.spring_boot_java_api_rest.api.exceptions.NotFoundException;
import br.com.spring_boot_java_api_rest.api.exceptions.UnsupportedMathOperationException;
import br.com.spring_boot_java_api_rest.api.serializer.OffsetDateTimeSerializer;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.OffsetDateTime;

@RestController
@ControllerAdvice
public class CustomResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(Exception.class)
    public final ResponseEntity<Object> handleGenericExceptions(
            Exception exception, WebRequest request
    ) {
        HttpStatus status = determineStatus(exception);
        return ResponseEntity.status(status.value()).body(
                ExceptionResponse.builder()
                        .timestamp(OffsetDateTime.now().format(OffsetDateTimeSerializer.ISO_8601_FORMATTER))
                        .status(status.value())
                        .error(status.getReasonPhrase())
                        .message(exception.getMessage())
                        .path(request.getDescription(false).substring(4))
                        .build()
                );
    }

    @ExceptionHandler(UnsupportedMathOperationException.class)
    public final ResponseEntity<Object> handleBadRequestExceptions(
            UnsupportedMathOperationException exception, WebRequest request
    ) {
        return ResponseEntity.status(exception.getHttpStatus().value()).body(
                ExceptionResponse.builder()
                        .timestamp(OffsetDateTime.now().format(OffsetDateTimeSerializer.ISO_8601_FORMATTER))
                        .status(exception.getHttpStatus().value())
                        .error(exception.getHttpStatus().getReasonPhrase())
                        .message(exception.getMessage())
                        .path(request.getDescription(false).substring(4))
                        .build()
        );
    }

    @ExceptionHandler(NotFoundException.class)
    public final ResponseEntity<Object> handleNotFoundException(
            NotFoundException exception, WebRequest request
    ) {
        HttpStatus status = determineStatus(exception);

        return ResponseEntity.status(status.value()).body(
                ExceptionResponse.builder()
                        .timestamp(OffsetDateTime.now().format(OffsetDateTimeSerializer.ISO_8601_FORMATTER))
                        .status(status.value())
                        .error(status.getReasonPhrase())
                        .message("O endpoint solicitado não existe")
                        .path(request.getDescription(false).substring(4))
                        .build()
        );
    }

    private HttpStatus determineStatus(Exception exception) {
        ResponseStatus annotation = AnnotationUtils.findAnnotation(exception.getClass(), ResponseStatus.class);
        return (annotation != null) ? annotation.code() : HttpStatus.INTERNAL_SERVER_ERROR;
    }
}
