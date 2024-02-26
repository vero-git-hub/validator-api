package com.example.validatorapi.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {

        Map<String, String> fieldErrors = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(error ->
                fieldErrors.put(error.getField(), error.getDefaultMessage()));

        Map<String, String> globalErrors = new HashMap<>();
        ex.getBindingResult().getGlobalErrors().forEach(error ->
                globalErrors.put(error.getObjectName(), error.getDefaultMessage()));

        Map<String, Object> body = new LinkedHashMap<>();
        body.put("timestamp", LocalDateTime.now());
        body.put("status", status.value());
        body.put("type", "Validation Error");
        body.put("detail", "See the fieldErrors and globalErrors for details.");

        if (!fieldErrors.isEmpty()) {
            body.put("fieldErrors", fieldErrors);
        }
        if (!globalErrors.isEmpty()) {
            body.put("globalErrors", globalErrors);
        }

        return new ResponseEntity<>(body, headers, status);
    }
}
