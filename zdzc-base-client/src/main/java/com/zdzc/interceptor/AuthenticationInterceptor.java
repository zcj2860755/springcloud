package com.zdzc.interceptor;

import com.zdzc.enums.ExceptionEnum;
import com.zdzc.utils.BaseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Enumeration;
import java.util.Set;

@Component

public class AuthenticationInterceptor implements HandlerInterceptor {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Resource(name="excludInterceptorSet")
    private Set<String> excludInterceptor;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse httpServletResponse, Object o) throws Exception {
        if(excludInterceptor.contains(request.getRequestURI()) || request.getRequestURI().contains("/webjars/springfox-swagger-ui/")){
            return true;
        }

        if(StringUtils.isEmpty(request.getHeader("Token"))){
            throw new BaseException(ExceptionEnum.SYSTEM_USER_TOKEN);
        }

        Enumeration<String> names = request.getParameterNames();
        StringBuilder sb = new StringBuilder();
        while (names.hasMoreElements())
        {
            String name = names.nextElement();
            String values = request.getParameter(name);
            sb.append(name + ":" + values + ", ");
        }
        logger.info("url="+request.getRequestURI()+"，paramters="+sb.toString());
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
