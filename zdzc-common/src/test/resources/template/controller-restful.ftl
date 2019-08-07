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
    public int add(@RequestBody ${modelNameUpperCamel} ${modelNameLowerCamel}){
        return ${modelNameLowerCamel}Service.save(${modelNameLowerCamel});
    }

    @DeleteMapping
    public int delete(@RequestParam String Id){
       return ${modelNameLowerCamel}Service.deleteById(Id);
    }

    @PutMapping
    public int update(@RequestBody ${modelNameUpperCamel} ${modelNameLowerCamel}){
       return ${modelNameLowerCamel}Service.update(${modelNameLowerCamel});
    }

    @GetMapping("/findById")
    public ${modelNameUpperCamel} detail(@RequestParam("id") String id){
        return ${modelNameLowerCamel}Service.findById(id);
    }

    @GetMapping
    public PageList<${modelNameUpperCamel}> list(@RequestBody ${modelNameUpperCamel} ${modelNameLowerCamel},BaseRequest baseRequest) {
        return ${modelNameLowerCamel}Service.list(${modelNameLowerCamel},baseRequest);
    }
}
