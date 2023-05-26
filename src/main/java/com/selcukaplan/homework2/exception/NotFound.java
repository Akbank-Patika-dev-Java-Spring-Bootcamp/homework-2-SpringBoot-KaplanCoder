package com.selcukaplan.homework2.exception;

import org.springframework.http.HttpStatus;

public class NotFound  extends   HTTPException{
    public NotFound(String message) {
        super(HttpStatus.NOT_FOUND,message);
    }

}
