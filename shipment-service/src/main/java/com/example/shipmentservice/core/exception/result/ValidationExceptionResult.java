package com.example.shipmentservice.core.exception.result;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ValidationExceptionResult extends ExceptionResult{
    private final List<String> errorMessage;
    public ValidationExceptionResult(List<String> errorMessage) {
        super("Validation Exception");
        this.errorMessage=errorMessage;
    }
}
