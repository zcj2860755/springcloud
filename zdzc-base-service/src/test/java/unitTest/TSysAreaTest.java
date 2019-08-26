package unitTest;

import com.zdzc.BasicServiceApplication;
import com.zdzc.controller.TSysAreaController;
import com.zdzc.model.TSysArea;
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
 * description :  省区市联动
 * author  : 李琳青
 * date   : 2019-08-22 10:49
 * version :1.0.0
 */


@RunWith(SpringRunner.class)
@SpringBootTest(classes = BasicServiceApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@FixMethodOrder(NAME_ASCENDING)
@Transactional
@Rollback
public class TSysAreaTest {

    @Resource
    private TSysAreaController tSysAreaController;



    /**
     *  根据id查询省市级
     */
    @Test
    public void test001(){
        TSysArea area = new TSysArea();
        tSysAreaController.selectProvinceCityAreaList(area);
    }


    /**
     *  根据id查询省市级
     */
    @Test
    public void test002(){
        TSysArea area = new TSysArea();
        area.setId(110000);
        tSysAreaController.selectProvinceCityAreaList(area);
    }



}
