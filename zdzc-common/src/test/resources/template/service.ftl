package ${basePackage}.service;

import ${basePackage}.model.${modelNameUpperCamel};
import com.zdzc.common.PageList;

/**
 * Author : ${author}
 * Date : ${date}
 */
public interface I${modelNameUpperCamel}Service {

    /**
    * @description：新增
    */
    int save(${modelNameUpperCamel} ${modelNameLowerCamel});

    /**
    * @description：修改
    */
    int update(${modelNameUpperCamel} ${modelNameLowerCamel});

    /**
    * @description：删除
    */
    int deleteById(String id);

    /**
    * @description：根据Id获取详情
    */
    ${modelNameUpperCamel} findById(String id);

    /**
    * @description：分页查询
    */
    PageList<${modelNameUpperCamel}> pageList(${modelNameUpperCamel} ${modelNameLowerCamel}, int pageNo, int pageSize);

}
