package ${basePackage}.controller;

import com.zdzc.common.BaseRequest;
import ${basePackage}.model.${modelNameUpperCamel};
import ${basePackage}.service.I${modelNameUpperCamel}Service;
import org.springframework.web.bind.annotation.*;
import com.zdzc.common.PageList;
import org.springframework.util.StringUtils;
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
        if(StringUtils.isEmpty(id)){
            throw new BaseException(ExceptionEnum.SYSTEM_PARAMSID_NULL);
        }
        return ${modelNameLowerCamel}Service.deleteById(id);
    }

    @PutMapping
    public int update(@RequestBody ${modelNameUpperCamel} ${modelNameLowerCamel}){
       return ${modelNameLowerCamel}Service.update(${modelNameLowerCamel});
    }

    @GetMapping("/findById")
    public ${modelNameUpperCamel} detail(@RequestParam("id") String id){
        if(StringUtils.isEmpty(id)){
            throw new BaseException(ExceptionEnum.SYSTEM_PARAMSID_NULL);
        }
        return ${modelNameLowerCamel}Service.findById(id);
    }

    @PostMapping("/pageList")
    public PageList<${modelNameUpperCamel}> pageList(@RequestBody ${modelNameUpperCamel} ${modelNameLowerCamel},
        @RequestParam(value="pageNo",defaultValue="1") Integer pageNo,@RequestParam(value="pageSize",defaultValue="10") Integer pageSize) {
        return ${modelNameLowerCamel}Service.pageList(${modelNameLowerCamel},pageNo,pageSize);
    }
}
