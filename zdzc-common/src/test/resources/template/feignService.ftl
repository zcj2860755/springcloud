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

    @GetMapping("${baseRequestMapping}/findById")
    ${modelNameUpperCamel} findById(@RequestParam String Id);

    @GetMapping("${baseRequestMapping}")
    PageList<${modelNameUpperCamel}> list(@RequestBody ${modelNameUpperCamel} ${modelNameLowerCamel});

    @PostMapping("${baseRequestMapping}")
    int add(@RequestBody ${modelNameUpperCamel} ${modelNameLowerCamel});

    @DeleteMapping("${baseRequestMapping}")
    int delete(@RequestParam String Id);

    @PutMapping("${baseRequestMapping}")
    int update(@RequestBody ${modelNameUpperCamel} ${modelNameLowerCamel});
}
