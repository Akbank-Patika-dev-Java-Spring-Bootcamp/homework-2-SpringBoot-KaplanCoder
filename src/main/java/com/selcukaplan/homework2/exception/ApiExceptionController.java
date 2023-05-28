package com.selcukaplan.homework2.exception;

import com.selcukaplan.homework2.general.RestResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class ApiExceptionController {


    @ExceptionHandler(value = {HTTPException.class})
    public ResponseEntity<Object> handleCustomExceptions(HTTPException e) {
        return  new ResponseEntity<>(RestResponse.error(e.getMessage()),e.getHttpStatus());
    }

    @ExceptionHandler(value = {Exception.class})
    public ResponseEntity<Object> handleAllExceptions(Exception e) {
        return  new ResponseEntity<>(RestResponse.error(e.getMessage()),HttpStatus.INTERNAL_SERVER_ERROR);
    }


}
