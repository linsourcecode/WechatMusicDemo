package cloud.dao;

import cloud.User_loginMain;
import cloud.entities.User_login;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface User_logindao {
    void add_login(User_login user_login);
    void count_login_time(String id);
}
