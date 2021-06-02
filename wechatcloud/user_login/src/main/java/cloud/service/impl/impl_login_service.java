package cloud.service.impl;

import cloud.User_loginMain;
import cloud.dao.User_logindao;
import cloud.dao.count_Userdao;
import cloud.entities.User_count;
import cloud.entities.User_login;
import cloud.service.login_service;
import cn.hutool.core.date.DateTime;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


@Service
@Slf4j
public class impl_login_service implements login_service {
    @Resource
    private User_logindao user_logindao;
    @Resource
    private count_Userdao count_userdao;
    @Override
    public void add_login(long  id)  {
        Date date = new Date();
        DateTime time = new DateTime(date);
        User_login user_login=new User_login(id,time,0,0);
       try {
           log.info("传递的数据为",id);
           user_logindao.add_login(user_login);
       }
        catch (Exception e){
           e.printStackTrace();
           log.error("插入主键重复，更新登录次数");
           user_logindao.count_login_time(id);

        }finally {
           //记录每次登录的时间
           User_count user_count=new User_count(id,time);
           count_userdao.setUser_count(user_count);

       }
           


    }

    @Override
    public void count_login_time(String id) {

    }
}
