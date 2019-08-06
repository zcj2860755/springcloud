package ${basePackage}.controller;

import com.zdzc.common.BaseRequest;
import ${basePackage}.model.${modelNameUpperCamel};
import ${basePackage}.service.I${modelNameUpperCamel}Service;
import org.springframework.web.bind.annotation.*;
import com.zdzc.common.PageList;

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
        ${modelNameLowerCamel}Service.save(${modelNameLowerCamel});
    }

    @DeleteMapping
    public void delete(@RequestParam String Id){
        ${modelNameLowerCamel}Service.deleteById(Id);
    }

    @PutMapping
    public void update(@RequestBody ${modelNameUpperCamel} ${modelNameLowerCamel}){
        ${modelNameLowerCamel}Service.update(${modelNameLowerCamel});
    }

    @GetMapping("findById")
    public ${modelNameUpperCamel} detail(@RequestParam String Id){
        return ${modelNameLowerCamel}Service.findById(Id);
    }

    @GetMapping
    public PageList<${modelNameUpperCamel}> list(@RequestBody ${modelNameUpperCamel} ${modelNameLowerCamel},BaseRequest baseRequest) {
        return ${modelNameLowerCamel}Service.list(${modelNameLowerCamel},baseRequest);
    }
}
