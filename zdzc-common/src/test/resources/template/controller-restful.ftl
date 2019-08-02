package ${basePackage}.controller;

import ${basePackage}.model.${modelNameUpperCamel};
import ${basePackage}.service.I${modelNameUpperCamel}Service;
import org.springframework.web.bind.annotation.*;
import com.zdzc.baseModel.PageList;

import javax.annotation.Resource;

/**
* Created by ${author} on ${date}.
*/
@RestController
@RequestMapping("${baseRequestMapping}")
public class ${modelNameUpperCamel}Controller {
    @Resource
    private I${modelNameUpperCamel}Service ${modelNameLowerCamel}Service;

    @PostMapping
    public void add(@RequestBody ${modelNameUpperCamel} ${modelNameLowerCamel}){

    }

    @PostMapping
    public void delete(@RequestBody ${modelNameUpperCamel} ${modelNameLowerCamel}){

    }

    @PostMapping
    public void update(@RequestBody ${modelNameUpperCamel} ${modelNameLowerCamel}){

    }

    @PostMapping()
    public ${modelNameUpperCamel} detail(@RequestBody ${modelNameUpperCamel} ${modelNameLowerCamel}){

        return null;
    }

    @PostMapping
    public PageList<${modelNameUpperCamel}> list(@RequestBody ${modelNameUpperCamel} ${modelNameLowerCamel}) {

        return null;
    }
}
