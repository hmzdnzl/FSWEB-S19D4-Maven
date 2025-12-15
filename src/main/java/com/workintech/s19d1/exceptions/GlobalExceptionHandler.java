package com.workintech.s19d1.exceptions;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ApiException.class)
    public ResponseEntity<?> handleApiException(ApiException ex) {
        return ResponseEntity.status(ex.getHttpStatus()).body(
            Map.of("message", ex.getMessage(), "status", ex.getHttpStatus().value())
        );
    }

      @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleGeneralException(Exception ex) {
        return ResponseEntity.status(500).body(
            Map.of("message", ex.getMessage(), "status", 500)
        );
    }
}
