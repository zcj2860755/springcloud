package com.zdzc.response;

import com.zdzc.common.BaseRespsonse;
import com.zdzc.utils.ExceptionResponse;
import org.springframework.context.annotation.ImportResource;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import javax.annotation.Resource;
import java.util.Set;


@ControllerAdvice
@ImportResource(locations= {"classpath:application-bean.xml"})
public class MyResponseBody implements ResponseBodyAdvice<Object> {

    @Resource(name="excludResponseSet")
    private Set<String> excludResponse;

    @Override
    public boolean supports(MethodParameter methodParameter, Class<? extends HttpMessageConverter<?>> aClass) {
        // 获取当前处理请求的controller的方法
        String methodName = methodParameter.getMethod().getName();

        // 是否处理返回值 true-处理 false-不处理
        return !excludResponse.contains(methodName);
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter methodParameter, MediaType mediaType, Class<? extends HttpMessageConverter<?>> aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
        if (body instanceof ExceptionResponse) {
            return BaseRespsonse.error((ExceptionResponse)body);
        }
        return BaseRespsonse.success(body);
    }
}
