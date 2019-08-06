package ${basePackage}.service;

import com.github.fangjinuo.sqlhelper.dialect.pagination.PagingResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import ${basePackage}.model.${modelNameUpperCamel};


/**
 * Author : ${author}
 * Date : ${date}
 */
@FeignClient(value = "${feifnClientName}")
public interface Feign${modelNameUpperCamel}Service {

    @GetMapping("${baseRequestMapping}/findById")
    String findById();

    @GetMapping("${baseRequestMapping}")
    PagingResult<${modelNameUpperCamel}> list();

    @PostMapping("${baseRequestMapping}")
    String add();

    @DeleteMapping("${baseRequestMapping}")
    String delete();

    @PutMapping("${baseRequestMapping}")
    String update();
}
