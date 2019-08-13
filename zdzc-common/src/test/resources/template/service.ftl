package ${basePackage}.service;

import ${basePackage}.model.${modelNameUpperCamel};
import com.zdzc.common.BaseRequest;
import com.zdzc.common.PageList;

/**
 * Author : ${author}
 * Date : ${date}
 */
public interface I${modelNameUpperCamel}Service {

    /**
    * @description：新增
    * @author：${author}
    * @date：${date}
    */
    int save(${modelNameUpperCamel} ${modelNameLowerCamel});

    /**
    * @description：修改
    * @author：${author}
    * @date：${date}
    */
    int update(${modelNameUpperCamel} ${modelNameLowerCamel});

    /**
    * @description：删除
    * @author：${author}
    * @date：${date}
    */
    int deleteById(String id);

    /**
    * @description：根据Id获取详情
    * @author：${author}
    * @date：${date}
    */
    ${modelNameUpperCamel} findById(String id);

    /**
    * @description：分页查询
    * @author：${author}
    * @date：${date}
    */
    PageList<${modelNameUpperCamel}> pageList(${modelNameUpperCamel} ${modelNameLowerCamel},BaseRequest baseRequest);

}
