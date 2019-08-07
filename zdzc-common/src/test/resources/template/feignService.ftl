package ${basePackage}.service;

import com.zdzc.common.PageList;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;
import ${basePackage}.model.${modelNameUpperCamel};


/**
 * Author : ${author}
 * Date : ${date}
 */
@FeignClient(value = "${feifnClientName}")
public interface Feign${modelNameUpperCamel}Service {

    @PostMapping("${baseRequestMapping}")
    int add(@RequestBody ${modelNameUpperCamel} ${modelNameLowerCamel});

    @DeleteMapping("${baseRequestMapping}")
    int delete(@RequestParam("id") String id);

    @PutMapping("${baseRequestMapping}")
    int update(@RequestBody ${modelNameUpperCamel} ${modelNameLowerCamel});

    @GetMapping("${baseRequestMapping}/findById")
    ${modelNameUpperCamel} findById(@RequestParam("id") String id);

    @GetMapping("${baseRequestMapping}")
    PageList<${modelNameUpperCamel}> list(@RequestBody ${modelNameUpperCamel} ${modelNameLowerCamel});


}
