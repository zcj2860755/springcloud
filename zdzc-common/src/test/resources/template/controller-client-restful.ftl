package ${basePackage}.controller;

import ${basePackage}.model.${modelNameUpperCamel};
import com.zdzc.service.Feign${modelNameUpperCamel}Service;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import springfox.documentation.annotations.ApiIgnore;
import com.zdzc.common.PageList;


/**
 * Description :
 * Author : ${author}
 * Date : ${date}
 */
@RestController
@RequestMapping("${baseRequestMapping}")
@Api(description = "接口描述")
public class ${modelNameUpperCamel}Controller {
    @Resource
    private Feign${modelNameUpperCamel}Service feign${modelNameLowerCamel}Service;

    @PostMapping
    @ApiOperation("新增")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "parameter", value = "参数", required = false, paramType = "query"),
    })
    public int add(@ApiIgnore ${modelNameUpperCamel} ${modelNameLowerCamel}){
        return feign${modelNameLowerCamel}Service.add(${modelNameLowerCamel});
    }

    @DeleteMapping
    @ApiOperation("删除")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "主键id", required = true, paramType = "query")
    })
    public int delete(String id){
        return feign${modelNameLowerCamel}Service.delete(id);
    }

    @PutMapping
    @ApiOperation("更新")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "parameter", value = "参数", required = false, paramType = "query"),
    })
    public int update(@ApiIgnore ${modelNameUpperCamel} ${modelNameLowerCamel}){
        return feign${modelNameLowerCamel}Service.update(${modelNameLowerCamel});
    }

    @GetMapping("/findById")
    @ApiOperation("获取详情")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "主键id", required = true, paramType = "query")
    })
    public ${modelNameUpperCamel} detail(String id){
        return feign${modelNameLowerCamel}Service.findById(id);
    }

    @PostMapping("/pageList")
    @ApiOperation("分页查询")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNo", value = "页数，默认1", required = false, paramType = "query"),
            @ApiImplicitParam(name = "pageSize", value = "每页展示，默认10，传0查全部", required = false, paramType = "query"),
    })
    public PageList<${modelNameUpperCamel}> pageList(@ApiIgnore ${modelNameUpperCamel} ${modelNameLowerCamel}) {
        return feign${modelNameLowerCamel}Service.pageList(${modelNameLowerCamel});
    }
}
