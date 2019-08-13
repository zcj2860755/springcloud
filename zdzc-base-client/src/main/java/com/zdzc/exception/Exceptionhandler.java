package com.zdzc.exception;


import com.zdzc.enums.ExceptionEnum;
import com.zdzc.utils.BaseException;
import com.zdzc.utils.ExceptionResponse;
import com.zdzc.utils.NohandlerException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

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
        if(e.getCode()!=0 && !StringUtils.isEmpty(e.getData())){
            return ExceptionResponse.create(e.getCode(),e.getData());
        }
        return ExceptionResponse.create(e.getExceptionEnum());
    }

    //异常不处理
    @ExceptionHandler(NohandlerException.class)
    public ExceptionResponse ExceptionNoHandle(NohandlerException e)
    {
        if(e.getExceptionEnum()==null){
            return ExceptionResponse.create(e.getCode(),e.getData());
        }
        return ExceptionResponse.create(e.getExceptionEnum());
    }

}
