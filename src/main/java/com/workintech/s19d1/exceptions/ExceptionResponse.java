package com.workintech.s19d1.exceptions;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class ExceptionResponse {
    private String message; 
    private int status; 
    private LocalDateTime dateTime;

    public ExceptionResponse(String message, int status, LocalDateTime dateTime) {
        this.dateTime=dateTime;
        this.message=message;
        this.status=status;
    }
}
