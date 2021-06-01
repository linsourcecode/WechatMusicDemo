package cloud.controller;


import cloud.User_loginMain;
import cloud.entities.CommonResult;
import cloud.entities.User_login;
import cloud.service.login_service;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Slf4j
public class User_login_Controller {
     @Resource
     private login_service login_service;
     @PostMapping(value="/login")
    public CommonResult post(String id){
            login_service.add_login(id);


            return new CommonResult(200,"成功");

     }



}
