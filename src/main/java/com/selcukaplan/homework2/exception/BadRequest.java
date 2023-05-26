package com.selcukaplan.homework2.exception;

import org.springframework.http.HttpStatus;

public class BadRequest extends HTTPException {

    public BadRequest(String message) {
        super(HttpStatus.BAD_REQUEST,message);
    }

}
