package com.github.sasachichito.demo.port.adapter.resource.error;

import org.openapi.example.model.ErrModel;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class UserExceptionHandler {

  @ExceptionHandler(IllegalArgumentException.class)
  @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
  ErrModel handle(IllegalArgumentException e) {
    ErrModel err = new ErrModel();
    err.code("D-001");
    err.message(e.getMessage());
    return err;
  }
}
