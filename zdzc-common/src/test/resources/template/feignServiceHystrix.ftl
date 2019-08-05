package ${basePackage}.hystrix;

import org.springframework.stereotype.Component;
import ${basePackage}.service.Feign${modelNameUpperCamel}Service;

/**
 * Created by ${author} on ${date}.
 */
@Component
public class Feign${modelNameUpperCamel}ServiceHystrix implements Feign${modelNameUpperCamel}Service {

    @Override
    public String findById(){
        return "service has fail!";
    };

    @Override
    public String list(){
        return "service has fail!";
    };

    @Override
    public String add(){
        return "service has fail!";
    };

    @Override
    public String delete(){
        return "service has fail!";
    };

    @Override
    public String put() {
        return "service has fail!";
    };
}
