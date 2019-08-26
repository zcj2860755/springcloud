package unitTest;


import com.zdzc.BasicServiceApplication;
import com.zdzc.common.BaseRequest;
import com.zdzc.controller.TSysDicCategoryController;
import com.zdzc.controller.TSysDicController;
import com.zdzc.model.TSysDicCategory;
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
 * description :  字典类别  test
 * author  : 李琳青
 * date   : 2019-08-22 10:51
 * version :1.0.0
 */


@RunWith(SpringRunner.class)
@SpringBootTest(classes = BasicServiceApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@FixMethodOrder(NAME_ASCENDING)
@Transactional
@Rollback
public class TSysDicCategoryTest {

    @Resource
    private TSysDicController tSysDicController;

    @Resource
    private TSysDicCategoryController tSysDicCategoryController;



    /**
     * 新增系统字典类别测试
     */
    @Test
    public void test001() {
        try {
            TSysDicCategory tSysDicCategory = new TSysDicCategory();
            tSysDicCategoryController.add(tSysDicCategory);
        } catch (BaseException e) {
            System.out.println(e.getMessage()+" test001");
        }
    }

    /**
     * 新增系统字典类别测试
     */
    @Test
    public void test002() {
        try {
            TSysDicCategory tSysDicCategory = new TSysDicCategory();
            tSysDicCategory.setDicKey("test111");
            tSysDicCategoryController.add(tSysDicCategory);
        } catch (BaseException e) {
            System.out.println(e.getMessage()+" test002");
        }
    }


    /**
     * 新增系统字典类别测试
     */
    @Test
    public void test003() {
        try {
            TSysDicCategory tSysDicCategory = new TSysDicCategory();
            tSysDicCategory.setDicKey("test111");
            tSysDicCategory.setDicValue("1");
            tSysDicCategoryController.add(tSysDicCategory);
        } catch (BaseException e) {
            System.out.println(e.getMessage()+" test003");
        }
    }

    /**
     * 新增系统字典类别测试
     */
    @Test
    public void test004() {
        try {
            TSysDicCategory tSysDicCategory = new TSysDicCategory();
            tSysDicCategory.setDicKey("test111");
            tSysDicCategory.setDicValue("1");
            tSysDicCategory.setIsEnable(1);
            tSysDicCategoryController.add(tSysDicCategory);
        } catch (BaseException e) {
            System.out.println(e.getMessage()+" test004");
        }
    }

    /**
     * 新增系统字典类别测试
     */
    @Test
    public void test005(){
        try {
            TSysDicCategory tSysDicCategory = new TSysDicCategory();
            tSysDicCategory.setDicKey("test111");
            tSysDicCategory.setDicValue("1");
            tSysDicCategory.setIsEnable(1);
            tSysDicCategory.setSortNo(20);
            tSysDicCategoryController.add(tSysDicCategory);
        }catch (BaseException e){
            System.out.println(e.getMessage()+" test005");
        }

    }


    /**
     * 更新系统字典类别测试
     */
    @Test
    public void test006(){
        try {
            TSysDicCategory tSysDicCategory = new TSysDicCategory();
            tSysDicCategoryController.update(tSysDicCategory);
        }catch (BaseException e){
            System.out.println(e.getMessage()+" test006");
        }

    }

    /**
     * 更新系统字典类别测试
     */
    @Test
    public void test007(){
        try {
            TSysDicCategory tSysDicCategory = new TSysDicCategory();
            tSysDicCategory.setId("test");
            tSysDicCategoryController.update(tSysDicCategory);
        }catch (BaseException e){
            System.out.println(e.getMessage()+" test007");
        }
    }



    /**
     * 更新系统字典类别测试
     */
    @Test
    public void test008(){
        try {
            TSysDicCategory tSysDicCategory = new TSysDicCategory();
            tSysDicCategory.setId("test");
            tSysDicCategory.setDicKey("test111");
            tSysDicCategoryController.update(tSysDicCategory);
        }catch (BaseException e){
            System.out.println(e.getMessage()+" test008");
        }
    }


    /**
     * 更新系统字典类别测试
     */
    @Test
    public void test009(){
        try {
            TSysDicCategory tSysDicCategory = new TSysDicCategory();
            tSysDicCategory.setId("test");
            tSysDicCategory.setDicKey("test111");
            tSysDicCategory.setDicValue("1");
            tSysDicCategoryController.update(tSysDicCategory);
        }catch (BaseException e){
            System.out.println(e.getMessage()+" test009");
        }
    }



    /**
     * 更新系统字典类别测试
     */
    @Test
    public void test010(){
        try {
            TSysDicCategory tSysDicCategory = new TSysDicCategory();
            tSysDicCategory.setId("test");
            tSysDicCategory.setDicKey("test111");
            tSysDicCategory.setDicValue("1");
            tSysDicCategory.setIsEnable(1);
            tSysDicCategoryController.update(tSysDicCategory);
        }catch (BaseException e){
            System.out.println(e.getMessage()+" test010");
        }

    }

    /**
     * 更新系统字典类别测试
     */
    @Test
    public void test011(){
        try {
            TSysDicCategory tSysDicCategory = new TSysDicCategory();
            tSysDicCategory.setId("test");
            tSysDicCategory.setDicKey("test111");
            tSysDicCategory.setDicValue("2");
            tSysDicCategory.setIsEnable(1);
            tSysDicCategory.setSortNo(20);
            tSysDicCategoryController.update(tSysDicCategory);
            System.out.println("test011");
        }catch (BaseException e){
            System.out.println(e.getMessage()+" test011");
        }

    }



    /**
     * 获取字典管理类别详情测试
     */
    @Test
    public void test012(){
        try {
            tSysDicCategoryController.detail("");
        }catch (BaseException e){
            System.out.println(e.getMessage()+" test012");
        }

    }

    /**
     * 获取字典管理类别详情测试
     */
    @Test
    public void test013(){
        try {
            tSysDicCategoryController.detail("dcb1bf9e2c714dabb8e4b723897ee354");
            System.out.println("test013");
        }catch (BaseException e){
            System.out.println(e.getMessage()+" test013");
        }
    }

    /**
     * 获取字典管理类别分页查询测试
     */
    @Test
    public void test014(){
        try {
            TSysDicCategory tSysDicCategory = new TSysDicCategory();
            BaseRequest BaseRequest = new BaseRequest();
            tSysDicCategoryController.pageList(tSysDicCategory,BaseRequest.getPageNo(),BaseRequest.getPageSize());
            System.out.println("test014");
        }catch (BaseException e){
            System.out.println(e.getMessage()+" test014");
        }
    }


    /**
     * 删除字典类别测试
     */
    @Test
    public void test015(){
        try {
            tSysDicCategoryController.delete("");
        }catch (BaseException e){
            System.out.println(e.getMessage()+" test015");
        }
    }

    /**
     * 删除字典类别测试
     */
    @Test
    public void test016(){
        try {
            tSysDicCategoryController.delete("test1");
            System.out.println("test016");
        }catch (BaseException e){
            System.out.println(e.getMessage()+" test016");
        }
    }




}
