package com.selcukaplan.homework2.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;


@Getter
@Setter
@RequiredArgsConstructor
public class HTTPException extends RuntimeException {


    private  final HttpStatus httpStatus;


    private final String message;

    public HTTPException(String message) {
        this(HttpStatus.INTERNAL_SERVER_ERROR,message);

    }






}
