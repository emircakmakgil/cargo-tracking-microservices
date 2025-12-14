package com.example.shipmentservice.core.exception.result;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BusinessExceptionResult extends ExceptionResult{
    private String errorMessage;
    public BusinessExceptionResult(String errorMessage) {
        super("Business Exception");
        this.errorMessage=errorMessage;
    }
}
