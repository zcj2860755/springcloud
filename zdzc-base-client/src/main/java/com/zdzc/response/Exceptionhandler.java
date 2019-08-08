package com.zdzc.response;



import com.zdzc.enums.ExceptionEnum;
import com.zdzc.utils.BaseException;
import com.zdzc.utils.ExceptionResponse;
import com.zdzc.utils.NohandlerException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.Set;

@RestControllerAdvice
public class Exceptionhandler {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    //系统异常，未知异常
    @ExceptionHandler(Exception.class)
    public ExceptionResponse handleException(Exception e)
    {
        logger.error("系统异常",e);
        return ExceptionResponse.create(ExceptionEnum.SYSTEM_ERROR);
    }

    //业务异常
    @ExceptionHandler(BaseException.class)
    public ExceptionResponse BaseExceptionhandle(BaseException e)
    {
        if(e.getExceptionEnum()==null){
            return ExceptionResponse.create(e.getCode(),e.getData());
        }
        return ExceptionResponse.create(e.getExceptionEnum());
    }

    @ExceptionHandler(NohandlerException.class)
    public ExceptionResponse ExceptionNoHandle(NohandlerException e)
    {
        if(e.getExceptionEnum()==null){
            return ExceptionResponse.create(e.getCode(),e.getData());
        }
        return ExceptionResponse.create(e.getExceptionEnum());
    }

    @ExceptionHandler(BindException.class)
    public ExceptionResponse handleBindException(BindException e)
    {
        BindingResult result = e.getBindingResult();
        return ExceptionResponse.create(500,result.getAllErrors().get(0).getDefaultMessage());
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ExceptionResponse handle(ConstraintViolationException e)
    {
        Set<ConstraintViolation<?>> errors = e.getConstraintViolations();
        StringBuilder strBuilder = new StringBuilder();
        for (ConstraintViolation<?> violation : errors) {
            strBuilder.append(violation.getMessage());
        }
        return ExceptionResponse.create(500,strBuilder.toString());
    }




}
