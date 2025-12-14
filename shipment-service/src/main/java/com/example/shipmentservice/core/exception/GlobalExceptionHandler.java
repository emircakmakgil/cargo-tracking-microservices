package com.example.shipmentservice.core.exception;


import com.example.shipmentservice.core.exception.result.BusinessExceptionResult;
import com.example.shipmentservice.core.exception.result.ExceptionResult;
import com.example.shipmentservice.core.exception.result.NotFoundException;
import com.example.shipmentservice.core.exception.result.ValidationExceptionResult;
import com.example.shipmentservice.core.exception.type.BusinessException;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler({Exception.class})
    @ResponseStatus(code= HttpStatus.INTERNAL_SERVER_ERROR)
    public ExceptionResult handleException(Exception e){
        return new ExceptionResult("Internal Server Error");
    }

    @ExceptionHandler({BusinessException.class})
    @ResponseStatus(code=HttpStatus.BAD_REQUEST)
    public BusinessExceptionResult handleBusinessException(BusinessException e){
        return new BusinessExceptionResult(e.getMessage());
    }

    @ExceptionHandler({MethodArgumentNotValidException.class})
    @ResponseStatus(code=HttpStatus.BAD_REQUEST)
    public ValidationExceptionResult handleMethodNotValidExcepiton(MethodArgumentNotValidException e){
        return new ValidationExceptionResult(e.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(error ->error.getDefaultMessage())
                .toList());
    }

    @ExceptionHandler({ChangeSetPersister.NotFoundException.class})
    @ResponseStatus(code=HttpStatus.BAD_REQUEST)
    public NotFoundException handleNotFoundException(ChangeSetPersister.NotFoundException e){
        return new NotFoundException(e.getMessage());
    }





}
