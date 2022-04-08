package com.zakirovemil.taskmanager.exception_handling;

import com.zakirovemil.taskmanager.exception_handling.exception.NoSuchUserException;
import com.zakirovemil.taskmanager.exception_handling.exception.UserAlreadyExistException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class UserGlobalExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<String> handleNoSuchUserException(NoSuchUserException exception) {
        return ResponseEntity.badRequest().body(exception.getMessage());
    }

    @ExceptionHandler
    public ResponseEntity<String> handleUserAlreadyExistException(UserAlreadyExistException exception) {
        return ResponseEntity.badRequest().body(exception.getMessage());
    }
}
