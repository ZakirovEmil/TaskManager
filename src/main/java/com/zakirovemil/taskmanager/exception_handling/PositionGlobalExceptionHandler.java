package com.zakirovemil.taskmanager.exception_handling;

import com.zakirovemil.taskmanager.exception_handling.exception.NoSuchPositionException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class PositionGlobalExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<String> handleNoSuchPositionException(NoSuchPositionException exception) {
        return ResponseEntity.badRequest().body(exception.getMessage());
    }

}
