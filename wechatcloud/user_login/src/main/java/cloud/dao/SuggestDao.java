package cloud.dao;

import cloud.entities.User_Suggest;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SuggestDao {
    void setSuggest(User_Suggest user_suggest);
}
