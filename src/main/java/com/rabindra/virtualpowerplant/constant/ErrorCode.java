package com.rabindra.virtualpowerplant.constant;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum ErrorCode {
    OK(0,"Ok", HttpStatus.OK),
    NOT_FOUND(404,"Please Provide Valid %S",HttpStatus.BAD_REQUEST),
    INTERNAL_SERVER_ERROR(500,"Please Contact Support Team",HttpStatus.INTERNAL_SERVER_ERROR);

    private final int code;
    private final String message;
    private final HttpStatus httpStatus;

    private ErrorCode(int code, String message, HttpStatus httpStatus){
        this.code=code;
        this.message=message;
        this.httpStatus=httpStatus;
    }


}
