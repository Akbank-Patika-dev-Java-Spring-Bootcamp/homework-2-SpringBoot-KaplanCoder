package com.selcukaplan.homework2.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class ApiExceptionController {

    private record ExceptionObject (String message,HttpStatus httpStatus) {};


    @ExceptionHandler(value = {HTTPException.class})
    public ResponseEntity<Object> handleApiRequestException(HTTPException e) {
        ExceptionObject exceptionObject= new ExceptionObject(e.getMessage(),e.getHttpStatus());
        return  new ResponseEntity<>(exceptionObject,exceptionObject.httpStatus);
    }


}
