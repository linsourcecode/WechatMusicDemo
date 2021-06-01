package cloud.service.impl;

import cloud.User_loginMain;
import cloud.dao.User_logindao;
import cloud.entities.User_login;
import cloud.service.login_service;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


@Service
@Slf4j
public class impl_login_service implements login_service {
    @Resource
    private User_logindao user_logindao;
    @Override
    public void add_login(String id) {
        java.util.Date date = new java.util.Date();   // 获取当前时间
        java.sql.Date sql_date = new java.sql.Date(date.getTime()); //转换成java.sql.Date
        User_login user_login=new User_login(id,sql_date,0,0);
       try {
           user_logindao.add_login(user_login);
       }
        catch (Exception e){
           log.error("插入主键重复，更新登录次数");
           user_logindao.count_login_time(id);

        }
           


    }

    @Override
    public void count_login_time(String id) {

    }
}
