package com.example.shipmentservice.core.exception.result;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NotFoundException extends ExceptionResult {
   private final String errorMessage;
    public NotFoundException(String errorMessage) {
        super("Not Found Exception");
        this.errorMessage=errorMessage;
    }
}
