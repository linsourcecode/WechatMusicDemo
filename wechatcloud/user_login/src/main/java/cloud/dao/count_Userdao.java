package cloud.dao;

import cloud.entities.User_Suggest;
import cloud.entities.User_count;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface count_Userdao {
    void setUser_count(User_count user_count);
    void setSuggest(User_Suggest user_suggest);
}
