package ${basePackage}.service.impl;

import ${basePackage}.dao.${modelNameUpperCamel}Mapper;
import ${basePackage}.model.${modelNameUpperCamel};
import ${basePackage}.service.I${modelNameUpperCamel}Service;
import org.springframework.stereotype.Service;
import com.github.pagehelper.PageHelper;
import com.zdzc.common.PageList;

import javax.annotation.Resource;

/**
 * Author : ${author}
 * Date : ${date}
 */
@Service
public class ${modelNameUpperCamel}ServiceImpl implements I${modelNameUpperCamel}Service {
    @Resource
    private ${modelNameUpperCamel}Mapper ${modelNameLowerCamel}Mapper;

    @Override
    public int save(${modelNameUpperCamel} ${modelNameLowerCamel}) {
        return ${modelNameLowerCamel}Mapper.insertSelective(${modelNameLowerCamel});
    }

    @Override
    public int update(${modelNameUpperCamel} ${modelNameLowerCamel}) {
        return ${modelNameLowerCamel}Mapper.updateByPrimaryKeySelective(${modelNameLowerCamel});
    }

    @Override
    public int deleteById(String id){
        return ${modelNameLowerCamel}Mapper.deleteByPrimaryKey(id);
    }

    @Override
    public ${modelNameUpperCamel} findById(String id){
        return ${modelNameLowerCamel}Mapper.selectByPrimaryKey(id);
    }

    @Override
    public PageList<${modelNameUpperCamel}> pageList(${modelNameUpperCamel} ${modelNameLowerCamel},int pageNo, int pageSize) {
        PageHelper.startPage(pageNo, pageSize);
        return new PageList<${modelNameUpperCamel}>(${modelNameLowerCamel}Mapper.select(${modelNameLowerCamel}));
    }
}
