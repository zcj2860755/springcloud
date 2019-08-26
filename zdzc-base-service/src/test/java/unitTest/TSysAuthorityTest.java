package unitTest;

import com.zdzc.BaseServiceApplication;
import com.zdzc.common.BaseRequest;
import com.zdzc.controller.TSysAuthorityController;
import com.zdzc.dao.TSysAuthorityMapper;
import com.zdzc.model.TSysAuthority;
import com.zdzc.utils.BaseException;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;
import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import static org.junit.runners.MethodSorters.NAME_ASCENDING;

/**
 * description :  菜单权限相关  test
 * author  : 李琳青
 * date   : 2019-08-22 10:50
 * version :1.0.0
 */

@RunWith(SpringRunner.class)
@SpringBootTest(classes = BaseServiceApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@FixMethodOrder(NAME_ASCENDING)
@Transactional
@Rollback
public class TSysAuthorityTest {

    @Resource
    private TSysAuthorityController tSysAuthorityController;

    @Resource
    private TSysAuthorityMapper tSysAuthorityMapper;

    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext webApplicationContext;

    private HttpSession session;

    /*@Before
    public void testProject0001(){
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }
    public void login() throws Exception {
        this.mockMvc.perform(post("/account/login")
                        .contentType(MediaType.APPLICATION_JSON)
                        .param("account","fire").param("password","123456"))
                .andExpect(status().isOk())
                .andDo(print())
                .andReturn().getRequest().getSession();
        System.out.println(" session: "+session);
    }*/




    /**
     * 菜单按钮权限新增测试
     */
    @Test
    public void test001() {
        try {
            TSysAuthority tSysAuthority = new TSysAuthority();
            tSysAuthorityController.add(tSysAuthority);
        }catch (BaseException e){
            System.out.println(e.getMessage());
        }
    }


    /**
     * 菜单按钮权限新增测试
     */
    @Test
    public void test002() {
        try {
            TSysAuthority tSysAuthority = new TSysAuthority();
            tSysAuthority.setAuthName("authTest");
            tSysAuthorityController.add(tSysAuthority);
        }catch (BaseException e){
            System.out.println(e.getMessage());
        }
    }


    /**
     * 菜单按钮权限新增测试
     */
    @Test
    public void test003() {
        try {
            TSysAuthority tSysAuthority = new TSysAuthority();
            tSysAuthority.setAuthName("authTest");
            tSysAuthority.setAuthSign("authTestSign");
            tSysAuthorityController.add(tSysAuthority);
        }catch (BaseException e){
            System.out.println(e.getMessage());
        }
    }


    /**
     * 菜单按钮权限新增测试
     */
    @Test
    public void test004() {
        try {
            TSysAuthority tSysAuthority = new TSysAuthority();
            tSysAuthority.setAuthName("authTest111");
            tSysAuthority.setAuthSign("authTestSign");
            tSysAuthority.setParentId("0");
            tSysAuthorityController.add(tSysAuthority);
        }catch (BaseException e){
            System.out.println(e.getMessage());
        }
    }


    /**
     * 菜单按钮权限新增测试
     */
    @Test
    public void test005() {
        try {
            TSysAuthority tSysAuthority = new TSysAuthority();
            tSysAuthority.setAuthName("authTest");
            tSysAuthority.setAuthSign("authTestSign");
            tSysAuthority.setParentId("0");
            tSysAuthority.setAuthType("1");
            tSysAuthority.setSortNo(2);
            tSysAuthorityController.add(tSysAuthority);
        }catch (BaseException e){
            System.out.println(e.getMessage());
        }
    }

    /**
     * 菜单权限删除
     */
    @Test
    public void test006() {
        try {
            tSysAuthorityController.delete("");
        }catch (BaseException e){
            System.out.println(e.getMessage());
        }
    }

    /**
     * 菜单权限删除
     */
    @Test
    public void test0061() {
        try {
            tSysAuthorityController.delete("123");
        }catch (BaseException e){
            System.out.println(e.getMessage());
        }
    }


    /**
     * 菜单权限更新测试
     */
    @Test
    public void test3001() {
        try {
            TSysAuthority authority = new TSysAuthority();
            tSysAuthorityController.update(authority);
            } catch (BaseException e){
              System.out.println(e.getMessage());
        }
    }

    /**
     * 菜单权限更新测试
     */
    @Test
    public void test3002() {
        try{
            TSysAuthority params2 = new TSysAuthority();
            params2.setId("23131");
            tSysAuthorityController.update(params2);
        }catch (BaseException e){
            System.out.println(e.getMessage());
        }
    }

    /**
     * 菜单权限更新测试
     */
    @Test
    public void test3003() {
        try{
            TSysAuthority params2 = new TSysAuthority();
            params2.setId("2313123");
            params2.setAuthName("authTest11");
            tSysAuthorityController.update(params2);
        }catch (BaseException e){

        }
    }

    /**
     * 菜单权限更新测试
     */
    @Test
    public void test3004() {
        try{
            TSysAuthority params2 = new TSysAuthority();
            params2.setId("2313123");
            params2.setAuthName("authTest11");
            params2.setParentId("0");
            tSysAuthorityController.update(params2);
        }catch (BaseException e){
        }
    }

    /**
     * 菜单权限更新测试
     */
    @Test
    public void test3005() {
        try{
            TSysAuthority params2 = new TSysAuthority();
            params2.setId("123124124");
            params2.setAuthName("authTest11");
            params2.setAuthSign("authTestSign");
            params2.setParentId("0");
            params2.setAuthType("2");
            tSysAuthorityController.update(params2);
        }catch (BaseException e){
            System.out.println(e.getMessage());
        }
    }

    /**
     * 菜单权限更新测试
     */
    @Test
    public void test3006() {
        try{
            TSysAuthority params2 = new TSysAuthority();
            params2.setId("123124124");
            params2.setAuthName("authTest11");
            params2.setAuthSign("authTestSign");
            params2.setParentId("0");
            tSysAuthorityController.update(params2);
        }catch (BaseException e){

        }
    }


    /**
     * 菜单权限获取详情测试
     */
    @Test
    public void test200() {
        try{
            tSysAuthorityController.detail("");
        }catch (BaseException e){
        }
    }


    /**
     * 菜单权限获取详情测试
     */
    @Test
    public void test201() {
        TSysAuthority params = new TSysAuthority();
        params.setAuthSign("cateDelete");
        TSysAuthority tSysAuthority = tSysAuthorityMapper.selectOne(params);
        if (tSysAuthority != null) {
            tSysAuthorityController.detail(tSysAuthority.getId());
        }
    }

    /**
     * 菜单权限分页查询测试
     */
    @Test
    public void test2001() {
        try{
            TSysAuthority tSysAuthority =new TSysAuthority();
            tSysAuthorityController.list(tSysAuthority);
        }catch (BaseException e){
        }
    }


    /**
     * 菜单权限分页查询测试
     */
    @Test
    public void test20010() {
        try{
            TSysAuthority tSysAuthority =new TSysAuthority();
            tSysAuthority.setSearchContent("111");
            tSysAuthorityController.list(tSysAuthority);
        }catch (BaseException e){
        }
    }


    /**
     * 菜单权限查询当前用户的所有权限测试
     */
    @Test
    public void test2002() throws Exception {
        try{
            TSysAuthority tSysAuthority =new TSysAuthority();
            tSysAuthorityController.getRoleAuthList(tSysAuthority);
        }catch (BaseException e){
        }
    }


    /**
     * 菜单权限查询当前用户的所有权限测试
     */
    @Test
    public void test20033() throws Exception {
        try{
            TSysAuthority tSysAuthority =new TSysAuthority();
            List<String>  list = new ArrayList<>();
            list.add("06802b4eb5eb456294530a036f8e200c");
            list.add("06930538123e42c9acdaa110a0828455");
            tSysAuthority.setIds(list);
            tSysAuthorityController.getRoleAuthList(tSysAuthority);
        }catch (BaseException e){
        }
    }



    /**
     * 查询所有权限
     */
    @Test
    public void test2004() {
        tSysAuthorityController.getAuthList();
    }


    /**
     * 权限列表
     */
    @Test
    public void test20050() throws Exception {
        try{
            TSysAuthority tSysAuthority =new TSysAuthority();
            tSysAuthorityController.getAllAuthList(tSysAuthority);
        }catch (BaseException e){
        }
    }

    /**
     * 菜单权限权限列表测试
     */
    @Test
    public void test2006() {
        TSysAuthority authority = new TSysAuthority();
        authority.setAuthName("系统配置");
        tSysAuthorityController.defaultAuth(authority);
    }


    /**
     * 菜单权限权限列表测试
     */
    @Test
    public void test2005() {
        TSysAuthority authority = new TSysAuthority();
        authority.setAuthSign("test");
        authority.setId("test01");
        tSysAuthorityController.existAuthSign(authority);
    }




    /**
     * 默认权限列表
     */
    @Test
    public void test5000() {
        try {
            TSysAuthority authority = new TSysAuthority();
            tSysAuthorityController.defaultAuth(authority);
        }catch (BaseException e){
            System.out.println(e.getMessage());
        }
    }

    /**
     * 默认权限列表
     */
    @Test
    public void test5001() {
        try {
            TSysAuthority authority = new TSysAuthority();
            authority.setAuthName("删除");
            tSysAuthorityController.defaultAuth(authority);
        }catch (BaseException e){
            System.out.println(e.getMessage());
        }
    }



}
