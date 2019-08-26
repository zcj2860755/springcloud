package unitTest;



import com.zdzc.BaseServiceApplication;
import com.zdzc.common.BaseRequest;
import com.zdzc.controller.TSysDicCategoryController;
import com.zdzc.controller.TSysDicController;
import com.zdzc.dao.TSysDicCategoryMapper;
import com.zdzc.dao.TSysDicMapper;
import com.zdzc.model.TSysDic;
import com.zdzc.model.TSysDicCategory;
import com.zdzc.utils.BaseException;
import org.junit.After;
import org.junit.Before;
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
 * description :  数据字典 test
 * author  : 李琳青
 * date   : 2019-08-22 10:52
 * version :1.0.0
 */


@RunWith(SpringRunner.class)
@SpringBootTest(classes = BaseServiceApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@FixMethodOrder(NAME_ASCENDING)
@Transactional
@Rollback
public class TSysDicTest {


    @Resource
    private TSysDicController tSysDicController;

    @Resource
    private TSysDicCategoryController tSysDicCategoryController;

    @Resource
    private TSysDicCategoryMapper tSysDicCategoryMapper;

    @Resource
    private TSysDicMapper tSysDicMapper;

    /**
     * 测试前创建用于测试的字典类别
     */
    @Before
    public void intiTest(){
        try {
            TSysDicCategory tSysDicCategory = new TSysDicCategory();
            tSysDicCategory.setDicKey("testP");
            tSysDicCategory.setDicValue("1");
            tSysDicCategory.setIsEnable(1);
            tSysDicCategory.setSortNo(20);
            tSysDicCategoryController.add(tSysDicCategory);
        }catch (BaseException e){
            System.out.println(e.getMessage());
        }
    }

    /**
     * 新增系统字典测试
     */
    @Test
    public void test001(){
        try {
            TSysDicCategory params = new TSysDicCategory();
            params.setDicKey("testP");
            TSysDicCategory params1 = tSysDicCategoryMapper.selectOne(params);
            if (params1 != null) {
                TSysDic tSysDic= new TSysDic();
                tSysDic.setCategoryId(params1.getId());
                tSysDic.setDicKey("testzql");
                tSysDic.setDicValue("1111");
                tSysDic.setIsEnable(1);
                tSysDic.setSortNo(1);
                tSysDicController.add(tSysDic);
                System.out.println(" test001");
            }
        }catch (BaseException e){
            System.out.println(e.getMessage()+" test001");
        }
    }

    /**
     * 新增系统字典测试
     */
    @Test
    public void test002(){
        try {
            TSysDic tSysDic= new TSysDic();
            tSysDicController.add(tSysDic);
        }catch (BaseException e){
            System.out.println(e.getMessage()+" test002");
        }
    }

    /**
     * 新增系统字典测试
     */
    @Test
    public void test003(){
        try {
            TSysDic tSysDic= new TSysDic();
            tSysDic.setCategoryId("testzql");
            tSysDicController.add(tSysDic);
        }catch (BaseException e){
            System.out.println(e.getMessage()+" test003");
        }
    }

    /**
     * 新增系统字典测试
     */
    @Test
    public void test004(){
        try {
            TSysDic tSysDic= new TSysDic();
            tSysDic.setCategoryId("testzql");
            tSysDic.setDicKey("testzql");
            tSysDicController.add(tSysDic);
        }catch (BaseException e){
            System.out.println(e.getMessage()+" test004");
        }
    }

    /**
     * 新增系统字典测试
     */
    @Test
    public void test005(){
        try {
            TSysDic tSysDic= new TSysDic();
            tSysDic.setCategoryId("testzql");
            tSysDic.setDicKey("testzql");
            tSysDic.setDicValue("2");
            tSysDicController.add(tSysDic);
        }catch (BaseException e){
            System.out.println(e.getMessage()+" test005");
        }
    }

    /**
     * 新增系统字典测试
     */
    @Test
    public void test006(){
        try {
            TSysDic tSysDic= new TSysDic();
            tSysDic.setCategoryId("testzql");
            tSysDic.setDicValue("2");
            tSysDic.setDicKey("testzql");
            tSysDic.setIsEnable(1);
            tSysDicController.add(tSysDic);
        }catch (BaseException e){
            System.out.println(e.getMessage()+" test006");
        }
    }

    /**
     * 新增系统字典测试
     */
    @Test
    public void test0061(){
        try {
            TSysDic tSysDic= new TSysDic();
            tSysDic.setCategoryId("testzql");
            tSysDic.setDicValue("2");
            tSysDic.setDicKey("eeee");
            tSysDic.setIsEnable(1);
            tSysDic.setSortNo(2);
            tSysDicController.add(tSysDic);
            System.out.println("test0061");
        }catch (BaseException e){
            System.out.println(e.getMessage()+" test0061");
        }
    }

    /**
     * 新增系统字典测试
     */
    @Test
    public void test0062(){
        try {
            TSysDicCategory params = new TSysDicCategory();
            params.setDicKey("testP");
            TSysDicCategory params1 = tSysDicCategoryMapper.selectOne(params);
            if (params1 != null) {
                TSysDic tSysDic= new TSysDic();
                tSysDic.setCategoryId(params1.getId());
                tSysDic.setDicValue("1111");
                tSysDic.setDicKey("eeee");
                tSysDic.setIsEnable(1);
                tSysDic.setSortNo(2);
                tSysDicController.add(tSysDic);
                System.out.println("test0062");
            }
        }catch (BaseException e){
            System.out.println(e.getMessage()+" test0062");
        }
    }

    /**
     * 系统字典查询测试
     */
    @Test
    public void test007(){
        TSysDic tSysDic= new TSysDic();
        BaseRequest BaseRequest = new BaseRequest();
        try {
        tSysDicController.pageList(tSysDic,BaseRequest.getPageNo(),BaseRequest.getPageSize());
        }catch (BaseException e){
            System.out.println(e.getMessage()+" test007");
        }
        System.out.println("test007");
    }

    /**
     * 获取系统字典详情测试
     */
    @Test
    public void test008(){
        try {
            TSysDic detail = tSysDicController.detail("");
        }catch(BaseException e){
            System.out.println(e.getMessage()+" test008");
        }
    }

    /**
     * 获取系统字典详情测试
     */
    @Test
    public void test0081(){
        try{
            TSysDic detail = tSysDicController.detail("123");
            System.out.println("test0081");
        }catch (BaseException e){
            System.out.println(e.getMessage()+" test0081");
        }

    }

    /**
     * 更新系统字典测试
     */
    @Test
    public void test009(){
        try {
            TSysDic tSysDic= new TSysDic();
            tSysDicController.update(tSysDic);
        }catch (BaseException e){
            System.out.println(e.getMessage()+" test009");
        }
    }

    /**
     * 更新系统字典测试
     */
    @Test
    public void test010(){
        try {
            TSysDic tSysDic= new TSysDic();
            tSysDic.setId("test");
            tSysDicController.update(tSysDic);
            System.out.println("test010");
        }catch (BaseException e){
            System.out.println(e.getMessage()+" test010");
        }
    }

    /**
     * 更新系统字典测试
     */
    @Test
    public void test011(){
        try {
            TSysDic tSysDic= new TSysDic();
            tSysDic.setId("test");
            tSysDic.setDicKey("testzql");
            tSysDicController.update(tSysDic);
        }catch (BaseException e){
            System.out.println(e.getMessage()+" test011");
        }
    }

    /**
     * 更新系统字典测试
     */
    @Test
    public void test012(){
        try {
            TSysDic tSysDic= new TSysDic();
            tSysDic.setId("test");
            tSysDic.setDicKey("testzql");
            tSysDic.setDicValue("3");
            tSysDicController.update(tSysDic);
        }catch (BaseException e){
            System.out.println(e.getMessage()+" test012");
        }
    }

    /**
     * 更新系统字典测试
     */
    @Test
    public void test013(){
        try {
            TSysDic tSysDic= new TSysDic();
            tSysDic.setId("test");
            tSysDic.setDicKey("testzql");
            tSysDic.setDicValue("3");
            tSysDic.setIsEnable(1);
            tSysDicController.update(tSysDic);
        }catch (BaseException e){
            System.out.println(e.getMessage()+" test013");
        }
    }


    /**
     * 更新系统字典测试
     */
    @Test
    public void test0131(){
        try {
            TSysDic tSysDic= new TSysDic();
            tSysDic.setId("test");
            tSysDic.setDicKey("testzql");
            tSysDic.setDicValue("3");
            tSysDic.setIsEnable(1);
            tSysDic.setSortNo(2);
            tSysDicController.update(tSysDic);
        }catch (BaseException e){
            System.out.println(e.getMessage()+" test0131");
        }
    }

    /**
     * 更新系统字典测试
     */
    @Test
    public void test0132(){
        try {
            TSysDic tSysDic= new TSysDic();
            tSysDic.setId("test");
            tSysDic.setDicKey("testzql");
            tSysDic.setDicValue("3");
            tSysDic.setIsEnable(1);
            tSysDic.setSortNo(2);
            tSysDicController.update(tSysDic);
        }catch (BaseException e){
            System.out.println(e.getMessage()+" test0131");
        }
    }

    /**
     * 更新系统字典测试
     */
    @Test
    public void test014(){
        try {
            TSysDic params1 = new TSysDic();
            params1.setDicKey("testzql");
            TSysDic params2 = tSysDicMapper.selectOne(params1);
            if(params2 != null){
                TSysDic tSysDic= new TSysDic();
                tSysDic.setId(params2.getId());
                tSysDic.setDicKey(params2.getDicKey());
                tSysDic.setDicValue("22");
                tSysDic.setIsEnable(1);
                tSysDic.setSortNo(2);
                tSysDicController.update(tSysDic);
            }else{
            }
            System.out.println("test014");
        }catch (BaseException e){
            e.printStackTrace();
            System.out.println(e.getMessage()+" test014");
        }
    }

    /**
     * 更新系统字典测试
     */
    @Test
    public void test0141(){
        try {
            TSysDic params1 = new TSysDic();
            params1.setDicKey("testzql");
            TSysDic params2 = tSysDicMapper.selectOne(params1);
            if(params2 != null){
                TSysDic tSysDic= new TSysDic();
                tSysDic.setId("1231231234");
                tSysDic.setDicKey(params2.getDicKey());
                tSysDic.setDicValue("22");
                tSysDic.setIsEnable(1);
                tSysDic.setSortNo(2);
                tSysDicController.update(tSysDic);
            }else{
            }
            System.out.println("test0141");
        }catch (BaseException e){
            e.printStackTrace();
            System.out.println(e.getMessage()+" test0141");
        }
    }


    /**
     * 删除系统字典测试
     */
    @Test
    public void test015(){
        try {
            tSysDicController.delete("");
        }catch (BaseException e){
            System.out.println(e.getMessage()+" test015");
        }
    }


    /**
     * 删除系统字典测试
     */
    @Test
    public void test0151(){
        try {
            tSysDicController.delete("test");
        }catch (BaseException e){
            System.out.println(e.getMessage()+" test015");
        }
    }



    /**
     * 删除系统字典测试
     */
    @Test
    public void test016(){
        try {
            TSysDic params1 = new TSysDic();
            params1.setDicKey("testzql");
            TSysDic params2 = tSysDicMapper.selectOne(params1);
            if(params2 != null){
                tSysDicController.delete(params2.getId());
            }
            System.out.println("test016");
        }catch (BaseException e){
            System.out.println(e.getMessage()+" test016");
        }
    }

    /**
     * 系统字典查询测试
     */
    @Test
    public void test017(){
        TSysDicCategory category = new TSysDicCategory();

        TSysDic tSysDic= new TSysDic();
        tSysDic.setCategoryId("dcb1bf9e2c714dabb8e4b723897ee354");
        BaseRequest BaseRequest = new BaseRequest();
        tSysDicController.pageList(tSysDic,BaseRequest.getPageNo(),BaseRequest.getPageSize());
        System.out.println("test017");
    }


    /**
     * 父类key查询子类list
     */
    @Test
    public void test018(){
        try {
        tSysDicController.getDicByDicKey("");
        }catch (BaseException e){
            System.out.println(e.getMessage());
        }
    }

    /**
     * 父类key查询子类list
     */
    @Test
    public void test019(){
        try {
            TSysDicCategory params = new TSysDicCategory();
            params.setDicKey("testP");
            TSysDicCategory category = tSysDicCategoryMapper.selectOne(params);
            if(category !=null){
                tSysDicController.getDicByDicKey(category.getId());
            }
        }catch (BaseException e){
            System.out.println(e.getMessage());
        }
    }


    /**
     * 测试后删除用于测试的字典类别
     */
    @After
    public void destoryTest(){
        try {
            TSysDicCategory params = new TSysDicCategory();
            params.setDicKey("testP");
            TSysDicCategory params1 = tSysDicCategoryMapper.selectOne(params);
            tSysDicCategoryController.delete(params1.getId());
            System.out.println("@After");
        }catch (BaseException e){
            System.out.println(e.getMessage()+" @After");
        }
    }




}
