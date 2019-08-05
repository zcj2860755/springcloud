package ${basePackage}.controller;

import ${basePackage}.model.${modelNameUpperCamel};
import ${basePackage}.service.I${modelNameUpperCamel}Service;
import org.springframework.web.bind.annotation.*;
import com.zdzc.common.PageList;

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

    @DeleteMapping
    public void delete(@RequestBody ${modelNameUpperCamel} ${modelNameLowerCamel}){

    }

    @PutMapping
    public void update(@RequestBody ${modelNameUpperCamel} ${modelNameLowerCamel}){

    }

    @GetMapping("findById")
    public ${modelNameUpperCamel} detail(@RequestBody ${modelNameUpperCamel} ${modelNameLowerCamel}){

        return null;
    }

    @GetMapping
    public PageList<${modelNameUpperCamel}> list(@RequestBody ${modelNameUpperCamel} ${modelNameLowerCamel}) {

        return null;
    }
}
