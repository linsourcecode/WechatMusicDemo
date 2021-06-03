package cloud.dao;

import cloud.entities.Song_info;
import cloud.entities.User_song;
import org.apache.ibatis.annotations.Mapper;

import java.math.BigInteger;

@Mapper
public interface Song_infodao {
    //记录用户播放记录
    void add_count(Song_info song_info);
    void update_count(BigInteger songid);
    void count(User_song user_song);
}
