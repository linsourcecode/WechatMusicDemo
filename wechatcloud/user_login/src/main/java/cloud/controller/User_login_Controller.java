package cloud.controller;


import cloud.User_loginMain;
import cloud.entities.CommonResult;
import cloud.entities.Play_Song;
import cloud.entities.User_Suggest;
import cloud.entities.User_login;
import cloud.service.login_service;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

@RestController
@Slf4j
public class User_login_Controller {
     @Resource
     private login_service login_service;
     @RequestMapping(value="/login/{id}")
    public CommonResult post(@PathVariable("id")  long id){
         Date date = new Date();
         SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
         String str = simpleDateFormat.format(date);
         System.out.println("用日期类Date获取当前的系统时间为：" );
         System.out.println(str);

         log.info("数据为",id);

         login_service.add_login(id);


            return new CommonResult(200,"成功");

     }
     @Value("${server.port}")
    private String serverPort;

    @RequestMapping(value = "/payment/consul")
    public String paymentConsul()
    {
        return "springcloud with consul: "+serverPort+"\t   "+ UUID.randomUUID().toString();
    }

    @RequestMapping("/suggest")
    public void test(@RequestBody User_Suggest user_suggest) {
        System.out.println("数据为"+user_suggest.toString());

        login_service.setSuggest(user_suggest);




    }



}
