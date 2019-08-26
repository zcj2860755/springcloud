package unitTest;


import com.zdzc.BaseServiceApplication;
import com.zdzc.controller.TSysParamsController;
import com.zdzc.model.TSysParams;
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
 * description :  系统参数Test
 * author  : 李琳青
 * date   : 2019-08-26 15:56
 * version :1.0.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = BaseServiceApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@FixMethodOrder(NAME_ASCENDING)
@Transactional
@Rollback
public class TSysParamsTest {

    @Resource
    private TSysParamsController tSysParamsController;



    /**
     * 新增系统参数测试
     */
    @Test
    public void test001() {
        try {
            TSysParams tSysParams = new TSysParams();
            tSysParamsController.add(tSysParams);
        } catch (BaseException e) {
            System.out.println(e.getMessage());
        }
    }


    /**
     * 新增系统参数测试
     */
    @Test
    public void test0010() {
        try {
            TSysParams tSysParams = new TSysParams();
            tSysParams.setParamsName("参数");
            tSysParamsController.add(tSysParams);
        } catch (BaseException e) {
            System.out.println(e.getMessage());
        }
    }


  /**
     * 新增系统参数测试
     */
    @Test
    public void test0011() {
        try {
            TSysParams tSysParams = new TSysParams();
            tSysParams.setParamsName("参数");
            tSysParams.setParamsKey("key");
            tSysParamsController.add(tSysParams);
        } catch (BaseException e) {
            System.out.println(e.getMessage());
        }
    }



  /**
     * 新增系统参数测试
     */
    @Test
    public void test0012() {
        try {
            TSysParams tSysParams = new TSysParams();
            tSysParams.setParamsName("参数");
            tSysParams.setParamsKey("key");
            tSysParams.setParamsValue("value");
            tSysParamsController.add(tSysParams);
        } catch (BaseException e) {
            System.out.println(e.getMessage());
        }
    }



    /**
     * 删除系统参数测试
     */
    @Test
    public void test002() {
        try {
            tSysParamsController.delete("");
        } catch (BaseException e) {
            System.out.println(e.getMessage());
        }
    }

 /**
     * 删除系统参数测试
     */
    @Test
    public void test0021() {
        try {
            tSysParamsController.delete("123456");
        } catch (BaseException e) {
            System.out.println(e.getMessage());
        }
    }


    /**
     * 修改系统参数测试
     */
    @Test
    public void test003() {
        try {
            TSysParams tSysParams = new TSysParams();
            tSysParamsController.update(tSysParams);
        } catch (BaseException e) {
            System.out.println(e.getMessage());
        }
    }


    /**
     * 修改系统参数测试
     */
    @Test
    public void test0031() {
        try {
            TSysParams tSysParams = new TSysParams();
            tSysParams.setParamsName("参数");
            tSysParamsController.update(tSysParams);
        } catch (BaseException e) {
            System.out.println(e.getMessage());
        }
    }


    /**
     * 修改系统参数测试
     */
    @Test
    public void test0032() {
        try {
            TSysParams tSysParams = new TSysParams();
            tSysParams.setParamsName("参数");
            tSysParams.setParamsKey("key");
            tSysParamsController.update(tSysParams);
        } catch (BaseException e) {
            System.out.println(e.getMessage());
        }
    }



    /**
     * 修改系统参数测试
     */
    @Test
    public void test0033() {
        try {
            TSysParams tSysParams = new TSysParams();
            tSysParams.setParamsName("参数");
            tSysParams.setParamsKey("key");
            tSysParams.setParamsValue("value");
            tSysParamsController.update(tSysParams);
        } catch (BaseException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * 修改系统参数测试
     */
    @Test
    public void test0034() {
        try {
            TSysParams tSysParams = new TSysParams();
            tSysParams.setId("123456");
            tSysParams.setParamsName("参数");
            tSysParams.setParamsKey("key");
            tSysParams.setParamsValue("value");
            tSysParamsController.update(tSysParams);
        } catch (BaseException e) {
            System.out.println(e.getMessage());
        }
    }


    /**
     * 查询详情系统参数测试
     */
    @Test
    public void test004() {
        try {
            tSysParamsController.detail("");
        } catch (BaseException e) {
            System.out.println(e.getMessage());
        }
    }

   /**
     * 查询详情系统参数测试
     */
    @Test
    public void test0041() {
        try {
            tSysParamsController.detail("123456");
        } catch (BaseException e) {
            System.out.println(e.getMessage());
        }
    }

 /**
     * 查询详情系统参数测试
     */
    @Test
    public void test005() {
        try {
            TSysParams tSysParams = new TSysParams();
            tSysParamsController.pageList(tSysParams,1,10);
        } catch (BaseException e) {
            System.out.println(e.getMessage());
        }
    }


}
