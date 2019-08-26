package com.zdzc.hystrix;



import com.alibaba.druid.util.StringUtils;
import com.zdzc.common.PageList;
import com.zdzc.common.Token;
import com.zdzc.enums.ExceptionEnum;
import com.zdzc.model.TSysAccount;
import com.zdzc.service.FeignExampleService;
import com.zdzc.service.FeignTSysAccountService;
import com.zdzc.utils.BaseException;
import feign.hystrix.FallbackFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public abstract class FeignTSysAccountServiceHystrix implements FallbackFactory<FeignTSysAccountService> {

}
