package cloud.service;

import cloud.entities.CommonResult;
import cloud.entities.User_Suggest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
//consul agent -dev
@Component
@FeignClient(value = "user-login-service")
public interface loginFeginService {
    @RequestMapping(value="/login/{id}")
    CommonResult post(@PathVariable("id")  long id);

    @RequestMapping("/suggest")
    CommonResult run(@RequestBody User_Suggest user_suggest);

}
