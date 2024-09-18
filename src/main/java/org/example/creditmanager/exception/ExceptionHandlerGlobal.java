package org.example.creditmanager.exception;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import static org.example.creditmanager.exception.ErrorConstants.UNEXPECTED_EXCEPTION;

@RestControllerAdvice
public class ExceptionHandlerGlobal {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ExceptionResponse> ExceptionHandler(final Exception ex) {
        return ResponseEntity.status(HttpStatusCode.valueOf(400))
                .body(ExceptionResponse.builder()
                        .message(UNEXPECTED_EXCEPTION.getMessage())
                        .code(UNEXPECTED_EXCEPTION.getCode())
                        .build());
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ExceptionResponse> NotFoundException(final NotFoundException ex) {
        return ResponseEntity.status(HttpStatusCode.valueOf(404)).body(
                ExceptionResponse.builder()
                        .message(ex.getMessage())
                        .code(ex.getCode())
                        .build()
        );
    }
}
