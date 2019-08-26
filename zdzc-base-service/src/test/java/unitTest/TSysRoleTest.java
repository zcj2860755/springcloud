package unitTest;

import com.zdzc.BaseServiceApplication;
import com.zdzc.controller.TSysRoleController;
import com.zdzc.dao.TSysRoleMapper;
import com.zdzc.model.TSysRole;
import com.zdzc.utils.BaseException;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

import static org.junit.runners.MethodSorters.NAME_ASCENDING;

/**
 * description :  角色相关
 * author  : 李琳青
 * date   : 2019-08-22 10:55
 * version :1.0.0
 */

@RunWith(SpringRunner.class)
@SpringBootTest(classes = BaseServiceApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@FixMethodOrder(NAME_ASCENDING)
@Transactional
@Rollback
public class TSysRoleTest {

    @Resource
    private TSysRoleController tSysRoleController;

    @Resource
    private TSysRoleMapper tSysRoleMapper;


    /**
     * 角色新增测试
     */
    @Test
    public void test10001(){
        try{
            TSysRole tSysRole = new TSysRole();
            tSysRoleController.add(tSysRole);
        }catch (BaseException e){
        }
    }


    /**
     * 角色新增测试
     */
    @Test
    public void test10002(){
        try{
            TSysRole tSysRole = new TSysRole();
            tSysRole.setRoleName("roleTest");
            tSysRoleController.add(tSysRole);
        }catch (BaseException e){
        }
    }

    /**
     * 角色新增测试
     */
    @Test
    public void test10003(){
        try{
            TSysRole tSysRole = new TSysRole();
            tSysRole.setRoleName("roleTest");
            tSysRole.setRoleSign("roleTest");
            tSysRoleController.add(tSysRole);
        }catch (BaseException e){
        }
    }


    /**
     * 角色删除测试
     */
    @Test
    public void test4000(){
        try {
            tSysRoleController.delete("");
        }catch (BaseException e){
        }
    }

    /**
     * 角色删除测试
     */
    @Test
    public void test4002(){
        try {
            tSysRoleController.delete("123");
        }catch (BaseException e){
        }
    }


    /**
     * 角色删除测试
     */
    @Test
    public void test4003(){
        try {
            tSysRoleController.delete("cb38622ef33c4bc086f94c052a6511e7");
        }catch (BaseException e){
        }
    }


    /**
     * 角色删除测试
     *//*
    @Test
    public void test4001(){
        try {
            TSysRole params = new TSysRole();
            params.setRoleName("权限所有-基本");
            params.setDelFlag(0);
            TSysRole tSysRole = tSysRoleMapper.selectOne(params);
            if(tSysRole != null){
                tSysRoleController.delete(tSysRole.getId());
            }
        }catch (BaseException e){
        }
    }*/



    /**
     * 获取详情测试
     */
    @Test
    public void test20001(){
        try{
            tSysRoleController.detail("");
        }catch (BaseException e){
        }
    }



    /**
     * 获取详情测试
     */
    @Test
    public void test2000(){
        try{
            tSysRoleController.detail("14c8cff4d7d940bc8801dbf03e07b29c");
        }catch (BaseException e){
        }
    }


    /**
     * 角色更新测试
     */
    @Test
    public void test30002(){
        try{
            TSysRole tSysRole = new TSysRole();
            tSysRoleController.update(tSysRole);
        }catch (BaseException e){
        }
    }

    /**
     * 角色更新测试
     */
    @Test
    public void test30003(){
        try{
            TSysRole tSysRole = new TSysRole();
            tSysRole.setId("123");
            tSysRoleController.update(tSysRole);
        }catch (BaseException e){
        }
    }




    /**
     * 分页查询测试
     */
    @Test
    public void test2001(){
        try{
            TSysRole tSysRole = new TSysRole();
            tSysRoleController.list(tSysRole);
        }catch (BaseException e){
        }
    }

    /**
     * 分页查询测试
     */
    @Test
    public void test2002(){
        try{
            TSysRole tSysRole = new TSysRole();
            tSysRole.setSearchContent("abc");
            tSysRoleController.list(tSysRole);
        }catch (BaseException e){
        }
    }


    /**
     * 获取用户角色
     */
    @Test
    public void test20034(){
        try{
            TSysRole tSysRole = new TSysRole();
            tSysRoleController.getUserRole(tSysRole);
        }catch (BaseException e){
        }
    }

    /**
     * 获取用户角色
     */
    @Test
    public void test20035(){
        try{
            TSysRole tSysRole = new TSysRole();
            tSysRole.setId("12222222");
            tSysRoleController.getUserRole(tSysRole);
        }catch (BaseException e){
        }
    }


    /**
     * 获取所有角色测试
     */
    @Test
    public void test2003(){
        try{
            tSysRoleController.findAllRole();
        }catch (BaseException e){
        }
    }



    /**
     * 获取所有角色测试
     */
    @Test
    public void test2004(){
        try{
            TSysRole tSysRole = new TSysRole();
            tSysRoleController.getUserRoleName(tSysRole);
        }catch (BaseException e){
        }
    }



    /**
     * 获取所有角色测试
     */
    @Test
    public void test20041(){
        try{
            TSysRole tSysRole = new TSysRole();
            tSysRole.setRoleName("roleTest");
            tSysRoleController.getUserRoleName(tSysRole);
        }catch (BaseException e){
        }
    }





}
