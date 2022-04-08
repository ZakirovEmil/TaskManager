package com.zakirovemil.taskmanager.exception_handling;

import com.zakirovemil.taskmanager.exception_handling.exception.NoSuchTaskException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class TaskGlobalExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<String> handleNoSuchTaskException(NoSuchTaskException exception) {
        return ResponseEntity.badRequest().body(exception.getMessage());
    }

}
