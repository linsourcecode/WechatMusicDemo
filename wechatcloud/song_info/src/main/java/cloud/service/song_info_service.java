package cloud.service;

import cloud.entities.Song_info;
import cloud.entities.User_song;

import java.util.List;

public interface song_info_service {
    void save_user_info(List<Song_info> song_info);
    void count(User_song user_song);
}
