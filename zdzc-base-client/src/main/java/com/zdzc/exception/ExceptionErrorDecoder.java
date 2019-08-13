package com.zdzc.exception;

import com.alibaba.fastjson.JSONObject;
import com.zdzc.baseModel.FeignException;
import com.zdzc.utils.BaseException;
import feign.Response;
import feign.Util;
import feign.codec.ErrorDecoder;
import jdk.nashorn.internal.runtime.regexp.joni.exception.InternalException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ExceptionErrorDecoder implements ErrorDecoder {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public Exception decode(String s, Response response) {
        FeignException ei = new FeignException();
        try {
            if (response.body() != null) {
                String body = Util.toString(response.body().asReader());
                ei = JSONObject.parseObject(body,FeignException.class);
                String message = ei.getMessage();
                if ("com.zdzc.utils.BaseException".equals(ei.getTrace())) {
                    String [] errorMsg= message.split(":");
                    BaseException businessException = new BaseException(Integer.parseInt(errorMsg[0]),errorMsg[1]);
                    return businessException;
                }
            }
        } catch (Exception e) {
            logger.error("系统异常",e);
            return new InternalException(e.getMessage());
        }
        logger.error("++++++++++"+ei.toString());
        return new InternalException("系统异常");
    }
}
