package cloud.service;

import cloud.User_loginMain;
import cloud.entities.User_Suggest;
import cloud.entities.User_login;

public interface login_service{

    void add_login(long  id);
    void count_login_time(String id);
    void setSuggest(User_Suggest user_suggest);
}
