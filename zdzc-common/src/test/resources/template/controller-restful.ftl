package ${basePackage}.controller;

import ${basePackage}.model.${modelNameUpperCamel};
import ${basePackage}.service.I${modelNameUpperCamel}Service;
import org.springframework.web.bind.annotation.*;
import com.github.fangjinuo.sqlhelper.dialect.pagination.PagingResult;

import javax.annotation.Resource;


/**
 * Author : ${author}
 * Date : ${date}
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
    public PagingResult<${modelNameUpperCamel}> list(@RequestBody ${modelNameUpperCamel} ${modelNameLowerCamel}) {

        return null;
    }
}
