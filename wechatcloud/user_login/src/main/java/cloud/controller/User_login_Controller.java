package cloud.controller;


import cloud.User_loginMain;
import cloud.entities.CommonResult;
import cloud.entities.User_login;
import cloud.service.login_service;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@Slf4j
public class User_login_Controller {
     @Resource
     private login_service login_service;
     @RequestMapping(value="/login/{id}")
    public CommonResult post(@PathVariable("id")  long id){
            log.info("数据为",id);
            String ids = String.valueOf(id);
            login_service.add_login(ids);


            return new CommonResult(200,"成功");

     }



}
