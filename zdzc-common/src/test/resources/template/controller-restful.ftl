package ${basePackage}.controller;

import com.zdzc.common.BaseRequest;
import ${basePackage}.model.${modelNameUpperCamel};
import ${basePackage}.service.I${modelNameUpperCamel}Service;
import org.springframework.web.bind.annotation.*;
import com.zdzc.common.PageList;

import javax.annotation.Resource;


/**
 * Description :
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
    public int delete(@RequestParam("id") String id){
       return ${modelNameLowerCamel}Service.deleteById(id);
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
    public PageList<${modelNameUpperCamel}> pageList(@RequestBody ${modelNameUpperCamel} ${modelNameLowerCamel},BaseRequest baseRequest) {
        return ${modelNameLowerCamel}Service.pageList(${modelNameLowerCamel},baseRequest);
    }
}
