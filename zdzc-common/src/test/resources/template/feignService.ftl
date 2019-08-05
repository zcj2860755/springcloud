package ${basePackage}.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

/**
 * Created by ${author} on ${date}.
 */
@FeignClient(value = "${feifnClientName}")
public interface Feign${modelNameUpperCamel}Service {

    @GetMapping("${baseRequestMapping}/findById")
    String findById();

    @GetMapping("${baseRequestMapping}")
    String list();

    @PostMapping("${baseRequestMapping}")
    String add();

    @DeleteMapping("${baseRequestMapping}")
    String delete();

    @PutMapping("${baseRequestMapping}")
    String put();
}
