package unitTest;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.zdzc.common.CommonStatus;
import com.zdzc.model.TSysAccount;
import com.zdzc.redis.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.util.StringUtils;
import org.springframework.web.context.WebApplicationContext;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class BaseTest {

    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Resource
    private RedisService redisService;

    private static HttpSession session;



        public void postMethod2(String url, String content) throws Exception {
            if(StringUtils.isEmpty(url) || StringUtils.isEmpty(content)){
                return;
            }
            mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
            mockMvc.perform(post(url)
                            .contentType(MediaType.APPLICATION_JSON)
                            .content(content))
                    .andExpect(status().isOk())
                    .andDo(print())
                    .andReturn();
        }


    public void deleteMethod2(String url, String content) throws Exception {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
        if(StringUtils.isEmpty(url) || StringUtils.isEmpty(content)){
            return;
        }
        mockMvc.perform(delete(url)
                .contentType(MediaType.APPLICATION_JSON)
                .content(content))
                .andExpect(status().isOk())
                .andDo(print())
                .andReturn();
    }

    public void putMethod2(String url, String content) throws Exception {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
        if(StringUtils.isEmpty(url) || StringUtils.isEmpty(content)){
            return;
        }
        mockMvc.perform(put(url)
                .contentType(MediaType.APPLICATION_JSON)
                .content(content))
                .andExpect(status().isOk())
                .andDo(print())
                .andReturn();
    }

    public void getMethod2(String url, String content) throws Exception {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
        if(StringUtils.isEmpty(url) || StringUtils.isEmpty(content)){
            return;
        }
        mockMvc.perform(get(url)
                .contentType(MediaType.APPLICATION_JSON)
                .content(content))
                .andExpect(status().isOk())
                .andDo(print())
                .andReturn();
    }








    /**
     * 登陆
     * @throws Exception
     */
    public String login(String account,String password) throws Exception {
        TSysAccount tSysAccount =new TSysAccount();
        tSysAccount.setAccount(account);
        tSysAccount.setPassword(password);
        String content = JSONObject.toJSONString(tSysAccount);
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
        String response = mockMvc.perform(
                post("/account/login").contentType(MediaType.APPLICATION_JSON_UTF8).content(content))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString();
        System.out.println("--------response: "+response);
        String uuid = JSON.parseObject(response).getString("uuid");
        String userId = JSON.parseObject(response).getString("userId");
        return uuid;
    }

    public void postMethod(String url, MultiValueMap<String,String> map) throws Exception {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
        if(StringUtils.isEmpty(url)){
            return;
        }
        if(StringUtils.isEmpty(map)){
            map=new LinkedMultiValueMap();
        }
        login("fire","123456");
        this.mockMvc
                .perform(post(url)
                        .session((MockHttpSession)session)
                        .contentType(MediaType.APPLICATION_JSON)
                        .params(map))
                .andExpect(status().isOk())
                .andDo(print())
                .andReturn();
    }


    public void getMethod(String url, MultiValueMap<String,String> map) throws Exception {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
        if(StringUtils.isEmpty(url)){
            return;
        }
        if(StringUtils.isEmpty(map)){
            map=new LinkedMultiValueMap();
        }
        login("fire","123456");
        this.mockMvc
                .perform(get(url)
                        .session((MockHttpSession)session)
                        .contentType(MediaType.APPLICATION_JSON)
                        .params(map))
                .andExpect(status().isOk())
                .andDo(print())
                .andReturn();
    }



    public void putMethod(String url, MultiValueMap<String,String> map) throws Exception {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
        if(StringUtils.isEmpty(url)){
            return;
        }
        if(StringUtils.isEmpty(map)){
            map=new LinkedMultiValueMap();
        }
        login("fire","123456");
        this.mockMvc
                .perform(put(url)
                        .session((MockHttpSession)session)
                        .contentType(MediaType.APPLICATION_JSON)
                        .params(map))
                .andExpect(status().isOk())
                .andDo(print())
                .andReturn();
    }

    public void deleteMethod(String url, MultiValueMap<String,String> map) throws Exception {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
        if(StringUtils.isEmpty(url)){
            return;
        }
        if(StringUtils.isEmpty(map)){
            map=new LinkedMultiValueMap();
        }
        login("fire","123456");
        this.mockMvc
                .perform(delete(url)
                        .session((MockHttpSession)session)
                        .contentType(MediaType.APPLICATION_JSON)
                        .params(map))
                .andExpect(status().isOk())
                .andDo(print())
                .andReturn();
    }
}
