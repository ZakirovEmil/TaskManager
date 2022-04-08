package com.zakirovemil.taskmanager.exception_handling;

import com.zakirovemil.taskmanager.exception_handling.exception.NoSuchUserPositionException;
import com.zakirovemil.taskmanager.exception_handling.exception.UserPositionAlreadyExistException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class UserPositionGlobalExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<String> handleUserPositionAlreadyExistException(UserPositionAlreadyExistException exception) {
        return ResponseEntity.badRequest().body(exception.getMessage());
    }

    @ExceptionHandler
    public ResponseEntity<String> handleNoSuchUserPositionException(NoSuchUserPositionException exception) {
        return ResponseEntity.badRequest().body(exception.getMessage());
    }

}
