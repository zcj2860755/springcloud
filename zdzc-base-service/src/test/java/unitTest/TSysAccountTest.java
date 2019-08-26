package unitTest;

import com.alibaba.fastjson.JSONObject;
import com.zdzc.BaseServiceApplication;
import com.zdzc.controller.TSysAccountController;
import com.zdzc.model.TSysAccount;
import com.zdzc.redis.RedisService;
import com.zdzc.utils.BaseException;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import java.util.HashMap;
import java.util.Map;

import static org.junit.runners.MethodSorters.NAME_ASCENDING;



@RunWith(SpringRunner.class)
@SpringBootTest(classes = BaseServiceApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@FixMethodOrder(NAME_ASCENDING)
@Transactional
@Rollback
public class TSysAccountTest extends BaseTest {


    @Resource
    private RedisService redisService;

    @Resource
    private TSysAccountController tSysAccountController;



    @Test
    public void test00000() throws Exception {
         login("fire", "123456");

    }


    /**
     * 用户新增
     */
    @Test
    public void test0001() throws Exception {
       try {
            TSysAccount tSysAccount =new TSysAccount();
            tSysAccountController.add(tSysAccount);
        }catch (BaseException e){
            System.out.println(e.getMessage());
        }
    }


    /**
     * 用户新增
     */
    @Test
    public void test00010() throws Exception {
        try {
        String uuid = login("fire", "123456");
        TSysAccount tSysAccount =new TSysAccount();
        tSysAccount.setUuid(uuid);
        tSysAccountController.add(tSysAccount);
        }catch (BaseException e){
            System.out.println(e.getMessage());
        }
    }


    /**
     * 用户新增
     */
    @Test
    public void test0002() throws Exception {
        try {
            String uuid = login("fire", "123456");
            TSysAccount tSysAccount =new TSysAccount();
            tSysAccount.setUuid(uuid);
            tSysAccount.setRealName("测试");
            tSysAccountController.add(tSysAccount);
        }catch (BaseException e){
            System.out.println(e.getMessage());
        }
    }

    /**
     * 用户新增
     */
    @Test
    public void test00021() throws Exception {
        try {
            String uuid = login("fire", "123456");
            TSysAccount tSysAccount =new TSysAccount();
            tSysAccount.setUuid(uuid);
            tSysAccount.setRealName("测试");
            tSysAccount.setAccount("ceshi");
            tSysAccountController.add(tSysAccount);
        }catch (BaseException e){
            System.out.println(e.getMessage());
        }
    }

    /**
     * 用户新增
     */
    @Test
    public void test0003() throws Exception {
        try {
            String uuid = login("fire", "123456");
            TSysAccount tSysAccount =new TSysAccount();
            tSysAccount.setUuid(uuid);
            tSysAccount.setRealName("测试");
            tSysAccount.setAccount("ceshi");
            tSysAccount.setPassword("ceshi");
            tSysAccountController.add(tSysAccount);
        }catch (BaseException e){
            System.out.println(e.getMessage());
        }
    }

    /**
     * 用户新增
     */
    @Test
    public void test0004() throws Exception {
        try {
            String uuid = login("fire", "123456");
            TSysAccount tSysAccount =new TSysAccount();
            tSysAccount.setUuid(uuid);
            tSysAccount.setRealName("测试");
            tSysAccount.setAccount("ceshi");
            tSysAccount.setPassword("ceshi");
            tSysAccount.setTel("ceshi");
            tSysAccountController.add(tSysAccount);
        }catch (BaseException e){
            System.out.println(e.getMessage());
        }
    }

    /**
     * 用户新增
     */
    @Test
    public void test0005() throws Exception {
        try {
            String uuid = login("fire", "123456");
            TSysAccount tSysAccount = new TSysAccount();
            tSysAccount.setUuid(uuid);
            tSysAccount.setRealName("测试");
            tSysAccount.setAccount("ceshi");
            tSysAccount.setPassword("ceshi");
            tSysAccount.setTel("ceshi");
            tSysAccount.setRoleId("ceshi");
            tSysAccountController.add(tSysAccount);
        } catch (BaseException e) {
            System.out.println(e.getMessage());
        }
    }


    /**
     * 用户新增
     */
    @Test
    public void test00051() throws Exception {
        try {
        String uuid = login("fire", "123456");
        TSysAccount tSysAccount =new TSysAccount();
        tSysAccount.setUuid(uuid);
        tSysAccount.setRealName("测试66666");
        tSysAccount.setAccount("ceshi1111111111111");
        tSysAccount.setPassword("ceshi");
        tSysAccount.setTel("ceshi");
        tSysAccount.setRoleId("ceshi");
        tSysAccountController.add(tSysAccount);
        } catch (BaseException e) {
            System.out.println(e.getMessage());
        }
    }


    /**
     * 用户登陆   1001002:用户名或密码不正确
     */
    @Test
    public void test0006() throws Exception {
        try {
            TSysAccount tSysAccount =new TSysAccount();
            tSysAccount.setAccount("1222");
            tSysAccount.setPassword("1234");
            HttpServletRequest request = null;
            tSysAccountController.login(tSysAccount,request);
        } catch (BaseException e) {
            System.out.println(e.getMessage());
        }

    }


    /**
     * 用户登陆
     */
    @Test
    public void test00061() throws Exception {
        login("fire","123456");
    }

    /**
     * 用户退出登陆
     */
    @Test
    public void test0007() throws Exception {
        try {
            TSysAccount tSysAccount =new TSysAccount();
            tSysAccount.setAccount("1222");
            tSysAccount.setPassword("1234");
            HttpServletRequest request = null;
            tSysAccountController.logout(tSysAccount,request);
        } catch (BaseException e) {
            System.out.println(e.getMessage());
        }
    }


    /**
     * 用户退出登陆
     */
    @Test
    public void test00071() throws Exception {
        try {
            TSysAccount tSysAccount =new TSysAccount();
            tSysAccount.setAccount("fire");
            tSysAccount.setPassword("123456");
            HttpServletRequest request = null;
            tSysAccountController.logout(tSysAccount,request);
        } catch (BaseException e) {
            System.out.println(e.getMessage());
        }
    }


    /**
     * 删除用户    先不写,可能要改--------------------------------------------
     */
    @Test
    public void test008() throws Exception {
      /*  String[] id = {};
        String[] ids = {};
        Map<String,String[]> map =new HashMap<>();
        map.put("id",id);
        map.put("ids",ids);
        String content = JSONObject.toJSONString(map);
        deleteMethod2("/account/deleteAccount","id");*/

        try {
            String[] id = {};
            String[] ids = {};
            TSysAccount tSysAccount =new TSysAccount();
            tSysAccountController.delete(null,null);
        } catch (BaseException e) {
            System.out.println(e.getMessage());
        }

    }




    /**
     * 用户更新
     */
    @Test
    public void test0012() throws Exception {
        try {
            TSysAccount tSysAccount =new TSysAccount();
            tSysAccountController.update(tSysAccount);
        } catch (BaseException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * 用户更新
     */
    @Test
    public void test0013() throws Exception {
        String uuid = login("fire", "123456");
        try {
            TSysAccount tSysAccount =new TSysAccount();
            tSysAccount.setUuid(uuid);
            tSysAccountController.update(tSysAccount);
        } catch (BaseException e) {
            System.out.println(e.getMessage());
        }
    }


    /**
     * 用户更新
     */
    @Test
    public void test00131() throws Exception {
        String uuid = login("fire", "123456");
        try {
            TSysAccount tSysAccount =new TSysAccount();
            tSysAccount.setUuid(uuid);
            tSysAccount.setId("123");
            tSysAccountController.update(tSysAccount);
        } catch (BaseException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * 用户更新
     */
    @Test
    public void test00132() throws Exception {
        String uuid = login("fire", "123456");
        try {
            TSysAccount tSysAccount =new TSysAccount();
            tSysAccount.setUuid(uuid);
            tSysAccount.setId("123");
            tSysAccountController.update(tSysAccount);
            tSysAccount.setRealName("测试");
        } catch (BaseException e) {
            System.out.println(e.getMessage());
        }
    }


    /**
     * 用户更新
     */
    @Test
    public void test00133() throws Exception {
        String uuid = login("fire", "123456");
        try {
            TSysAccount tSysAccount =new TSysAccount();
            tSysAccount.setUuid(uuid);
            tSysAccount.setId("123");
            tSysAccount.setRealName("测试");
            tSysAccount.setAccount("ceshi");
            tSysAccountController.update(tSysAccount);
        } catch (BaseException e) {
            System.out.println(e.getMessage());
        }
    }


    /**
     * 用户更新
     */
    @Test
    public void test00134() throws Exception {
        String uuid = login("fire", "123456");
        try {
            TSysAccount tSysAccount =new TSysAccount();
            tSysAccount.setUuid(uuid);
            tSysAccount.setId("123");
            tSysAccount.setRealName("测试");
            tSysAccount.setAccount("ceshi");
            tSysAccount.setRoleId("ceshi");
            tSysAccountController.update(tSysAccount);
        } catch (BaseException e) {
            System.out.println(e.getMessage());
        }
    }


    /**
     * 用户更新
     */
    @Test
    public void test00135() throws Exception {
        String uuid = login("fire", "123456");
        try {
            TSysAccount tSysAccount =new TSysAccount();
            tSysAccount.setUuid(uuid);
            tSysAccount.setId("123");
            tSysAccount.setRealName("测试");
            tSysAccount.setAccount("ceshi");
            tSysAccount.setRoleId("ceshi");
            tSysAccount.setStatus(1);
            tSysAccountController.update(tSysAccount);
        } catch (BaseException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * 用户更新
     */
    @Test
    public void test00136() throws Exception {
        String uuid = login("fire", "123456");
        try {
            TSysAccount tSysAccount =new TSysAccount();
            tSysAccount.setUuid(uuid);
            tSysAccount.setId("123");
            tSysAccount.setRealName("测试");
            tSysAccount.setAccount("ceshi");
            tSysAccount.setRoleId("ceshi");
            tSysAccount.setStatus(1);
            tSysAccount.setTel("13333333333");
            tSysAccountController.update(tSysAccount);
        } catch (BaseException e) {
            System.out.println(e.getMessage());
        }
    }



    /**
     * 用户详情
     */
    @Test
    public void test0014() throws Exception {
        TSysAccount tSysAccount =new TSysAccount();
        String content = JSONObject.toJSONString(tSysAccount);
        getMethod2("/account/1234",content);
    }

    /**
     * 用户详情
     */
    @Test
    public void test0018() throws Exception {
       /* TSysAccount tSysAccount =new TSysAccount();
        String content = JSONObject.toJSONString(tSysAccount);
        getMethod2("/account/0",content);*/
        try {
            tSysAccountController.detail("0");
        } catch (BaseException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * 用户分页查询
     */
    @Test
    public void test0019() throws Exception {
        try {
            TSysAccount tSysAccount =new TSysAccount();
            tSysAccountController.list(tSysAccount);
        } catch (BaseException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * 用户分页查询
     */
    @Test
    public void test00190() throws Exception {
        String uuid = login("fire", "123456");
        TSysAccount tSysAccount =new TSysAccount();
        tSysAccount.setUuid(uuid);
        String content = JSONObject.toJSONString(tSysAccount);
        postMethod2("/account/list",content);
    }


    /**
     *  获取该项目下未绑定的用户加项目自身管理员
     */
    @Test
    public void test001910() throws Exception {
        /*TSysAccount tSysAccount =new TSysAccount();
        String content = JSONObject.toJSONString(tSysAccount);
        postMethod2("/account/manger",content);*/
        try {
            TSysAccount tSysAccount =new TSysAccount();
            tSysAccountController.findMangerList(tSysAccount);
        } catch (BaseException e) {
            System.out.println(e.getMessage());
        }
    }


    /**
     *  获取该项目下未绑定的用户加项目自身管理员
     */
    @Test
    public void test001911() throws Exception {
        String uuid = login("fire", "123456");
        TSysAccount tSysAccount =new TSysAccount();
        tSysAccount.setUuid(uuid);
        try {
            tSysAccountController.findMangerList(tSysAccount);
        } catch (BaseException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     *  获取该项目下未绑定的用户加项目自身管理员
     */
    @Test
    public void test001912() throws Exception {
        String uuid = login("fire", "123456");
        TSysAccount tSysAccount =new TSysAccount();
        tSysAccount.setUuid(uuid);
        tSysAccount.setProId("123456");
        try {
            tSysAccountController.findMangerList(tSysAccount);
        } catch (BaseException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * 验证用户账号是否存在
     */
    @Test
    public void test0020() throws Exception {
        TSysAccount tSysAccount =new TSysAccount();
        try {
            tSysAccountController.findverifyAccount(tSysAccount);
        } catch (BaseException e) {
            System.out.println(e.getMessage());
        }
    }


    /**
     * 验证用户账号是否存在
     */
    @Test
    public void test0021() throws Exception {
      /*  TSysAccount tSysAccount =new TSysAccount();
        tSysAccount.setAccount("fire");
        String content = JSONObject.toJSONString(tSysAccount);
        postMethod2("/account/verifyAccount",content);*/
        TSysAccount tSysAccount =new TSysAccount();
        try {
            tSysAccount.setAccount("fire");
            tSysAccountController.findverifyAccount(tSysAccount);
        } catch (BaseException e) {
            System.out.println(e.getMessage());
        }
    }


    /**
     * 验证用户账号是否存在
     */
    @Test
    public void test00210() throws Exception {
        TSysAccount tSysAccount =new TSysAccount();
        tSysAccount.setAccount("fire11111111");
        String content = JSONObject.toJSONString(tSysAccount);
        postMethod2("/account/verifyAccount",content);
    }



    /**
     * 修改密码
     */
    @Test
    public void test0023() throws Exception {
        try {
            TSysAccount tSysAccount =new TSysAccount();
            HttpServletRequest request =null;
            tSysAccountController.updatePW(tSysAccount,request);
        } catch (BaseException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * 修改密码
     */
    @Test
    public void test0024() throws Exception {
        String uuid = login("fire", "123456");
        try {
            TSysAccount tSysAccount =new TSysAccount();
            tSysAccount.setUuid(uuid);
            HttpServletRequest request =null;
            tSysAccountController.updatePW(tSysAccount,request);
        } catch (BaseException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * 修改密码
     */
    @Test
    public void test0025() throws Exception {
        String uuid = login("fire", "123456");
        try {
            TSysAccount tSysAccount =new TSysAccount();
            tSysAccount.setUuid(uuid);
            HttpServletRequest request =null;
            tSysAccount.setId("123");
            tSysAccountController.updatePW(tSysAccount,request);
        } catch (BaseException e) {
            System.out.println(e.getMessage());
        }
       /* String uuid = login("fire", "123456");
        TSysAccount tSysAccount =new TSysAccount();
        tSysAccount.setUuid(uuid);

        String content = JSONObject.toJSONString(tSysAccount);
        putMethod2("/account/updatePW/0",content);*/
    }

    /**
     * 修改密码
     */
    @Test
    public void test0026() throws Exception {
        String uuid = login("fire", "123456");
        try {
            TSysAccount tSysAccount =new TSysAccount();
            tSysAccount.setUuid(uuid);
            HttpServletRequest request =null;
            tSysAccount.setId("123");
            tSysAccount.setOldPassword("123456");
            tSysAccountController.updatePW(tSysAccount,request);
        } catch (BaseException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * 修改密码
     */
    @Test
    public void test0027() throws Exception {
        String uuid = login("fire", "123456");
        try {
            TSysAccount tSysAccount =new TSysAccount();
            tSysAccount.setUuid(uuid);
            HttpServletRequest request =null;
            tSysAccount.setId("1d1b49b7ecb04955a2ca55898fdd4e1d");
            tSysAccount.setOldPassword("123456");
            tSysAccount.setPassword("123456");
            tSysAccountController.updatePW(tSysAccount,request);
        } catch (BaseException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * 查询启用的用户
     */
    @Test
    public void test0028() throws Exception {
        try {
            TSysAccount tSysAccount =new TSysAccount();
            tSysAccountController.list(tSysAccount);
        } catch (BaseException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * 查询启用的用户
     */
    @Test
    public void test00281() throws Exception {
        String uuid = login("fire", "123456");
        try {
            TSysAccount tSysAccount =new TSysAccount();
            tSysAccount.setUuid(uuid);
            tSysAccountController.list(tSysAccount);
        } catch (BaseException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * 查询启用的用户
     */
    @Test
    public void test00282() throws Exception {
        String uuid = login("fire", "123456");
        try {
            TSysAccount tSysAccount =new TSysAccount();
            tSysAccount.setUuid(uuid);
            tSysAccount.setProjectId("123");
            tSysAccountController.list(tSysAccount);
        } catch (BaseException e) {
            System.out.println(e.getMessage());
        }
    }


}
