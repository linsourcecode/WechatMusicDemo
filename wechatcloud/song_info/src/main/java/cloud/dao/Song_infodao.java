package cloud.dao;

import cloud.entities.Song_info;
import cloud.entities.User_song;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface Song_infodao {
    //记录用户播放记录
    void add_count(Song_info song_info);
    void user_song(User_song user_song);
}
