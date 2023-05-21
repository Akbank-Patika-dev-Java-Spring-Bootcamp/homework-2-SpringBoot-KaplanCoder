package com.selcukaplan.homework2.exceptions;

import lombok.AllArgsConstructor;
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

    private final LocalDateTime errorDate;

    private final String message;

    public HTTPException(String message) {
        this(HttpStatus.INTERNAL_SERVER_ERROR,LocalDateTime.now(),message);

    }

    public HTTPException(LocalDateTime errorDate,String message) {
        this(HttpStatus.INTERNAL_SERVER_ERROR,errorDate,message);
    }

    public HTTPException(HttpStatus httpStatus,String message) {
        this(httpStatus,LocalDateTime.now(),message);

    }





}
