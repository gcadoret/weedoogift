package com.weedoogift.web.config;

import com.weedoogift.domain.exception.CompanyNotFoundException;
import com.weedoogift.domain.exception.UnsufficientBalanceCompanyException;
import com.weedoogift.domain.exception.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(UnsufficientBalanceCompanyException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public ResponseEntity<Object> handleNoSuchElementFoundException(UnsufficientBalanceCompanyException exception) {
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler({CompanyNotFoundException.class, UserNotFoundException.class})
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<Object> handleNotFoundException(RuntimeException exception) {
        return ResponseEntity.notFound().build();
    }
}
