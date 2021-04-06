package com.duydoanx.film.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.time.LocalDateTime;

@ControllerAdvice
public class GenericExceptionHandler {

    @ExceptionHandler(MissingServletRequestParameterException.class)
    public ResponseEntity<Object> handleMissingParams(MissingServletRequestParameterException ex) {
        GenericErrorResponse errorResponse = new GenericErrorResponse(
                HttpStatus.BAD_REQUEST.value(),
                ex.getParameterName() + " parameter is missing", LocalDateTime.now());
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<Object> handleMissingParams(MethodArgumentTypeMismatchException ex) {
        GenericErrorResponse errorResponse = new GenericErrorResponse(
                HttpStatus.BAD_REQUEST.value(),
                "Wrong variable data type!", LocalDateTime.now());
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<Object> handleRuntimeException(RuntimeException ex) {
        GenericErrorResponse errorResponse = new GenericErrorResponse(
                HttpStatus.BAD_REQUEST.value(),
                ex.getMessage(), LocalDateTime.now());
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(OutPageSizeException.class)
    public ResponseEntity<Object> handleMissingParams(OutPageSizeException ex) {
        GenericErrorResponse errorResponse = new GenericErrorResponse(
                HttpStatus.BAD_REQUEST.value(),
                "The requested page has exceeded the number of elements!", LocalDateTime.now());
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ItemNotFoundException.class)
    public ResponseEntity<Object> handleMissingParams(ItemNotFoundException ex) {
        GenericErrorResponse errorResponse = new GenericErrorResponse(
                HttpStatus.BAD_REQUEST.value(),
                ex.getMessage(), LocalDateTime.now());
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ItemAddFailureException.class)
    public ResponseEntity<Object> handleMovieAddingWrongMethod(ItemAddFailureException ex) {
        GenericErrorResponse errorResponse = new GenericErrorResponse(
                HttpStatus.BAD_REQUEST.value(),
                ex.getMessage(), LocalDateTime.now());
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

}
