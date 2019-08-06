package ${basePackage}.service.impl;

import ${basePackage}.dao.${modelNameUpperCamel}Mapper;
import ${basePackage}.model.${modelNameUpperCamel};
import ${basePackage}.service.I${modelNameUpperCamel}Service;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Author : ${author}
 * Date : ${date}
 */
@Service
public class ${modelNameUpperCamel}ServiceImpl implements I${modelNameUpperCamel}Service {
    @Resource
    private ${modelNameUpperCamel}Mapper ${modelNameLowerCamel}Mapper;

}
