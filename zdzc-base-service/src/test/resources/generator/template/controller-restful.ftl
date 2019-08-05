package ${basePackage}.controller;

import com.zdzc.common.model.BaseRequest;
import ${basePackage}.model.${modelNameUpperCamel};
import ${basePackage}.service.I${modelNameUpperCamel}Service;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import springfox.documentation.annotations.ApiIgnore;
import com.zdzc.common.utils.BaseException;
import com.zdzc.common.model.PageList;

import javax.annotation.Resource;

/**
* Created by ${author} on ${date}.
*/
@RestController
@RequestMapping("${baseRequestMapping}")
@Api
public class ${modelNameUpperCamel}Controller {
    @Resource
    private I${modelNameUpperCamel}Service ${modelNameLowerCamel}Service;

    @PostMapping
    @ApiOperation("新增")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "parameter", value = "参数", required = false, paramType = "query")
    })
    public void add(@ApiIgnore ${modelNameUpperCamel} ${modelNameLowerCamel}){
        //${modelNameLowerCamel}Service.save(${modelNameLowerCamel});
    }

    @DeleteMapping("/{id}")
    @ApiOperation("删除")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "parameter", value = "参数", required = false, paramType = "path")
    })
    public void delete(@PathVariable String id){
        //${modelNameLowerCamel}Service.deleteById(id);
    }

    @PutMapping
    @ApiOperation("更新")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "parameter", value = "参数", required = false, paramType = "query")
    })
    public void update(@ApiIgnore ${modelNameUpperCamel} ${modelNameLowerCamel}){
        //${modelNameLowerCamel}Service.update(${modelNameLowerCamel});
    }

    @GetMapping("/{id}")
    @ApiOperation("获取详情")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "parameter", value = "参数", required = false, paramType = "path")
    })
    public ${modelNameUpperCamel} detail(@PathVariable String id){
        //${modelNameLowerCamel}Service.findById(id);
        return null;
    }

    @GetMapping
    @ApiOperation("分页查询")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNo", value = "页数", required = false, paramType = "query"),
            @ApiImplicitParam(name = "pageSize", value = "每页展示", required = false, paramType = "query")
    })
    public PageList<${modelNameUpperCamel}> list(@ApiIgnore ${modelNameUpperCamel} ${modelNameLowerCamel},BaseRequest baseRequest) {
        // ${modelNameLowerCamel}Service.findAll()
        return null;
    }
}
