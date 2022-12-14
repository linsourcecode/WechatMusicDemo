package cloud.service.impl;

import cloud.dao.Song_infodao;
import cloud.entities.Song_info;
import cloud.entities.User_song;
import cloud.service.song_info_service;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
@Slf4j
public class Song_info_service_info implements song_info_service {
    @Resource
    private Song_infodao song_infodao;
    @Override
    public void save_user_info(List<Song_info> song_info) {
        for(Song_info song_info1:song_info){

          try{
            song_infodao.add_count(song_info1);}
          catch (Exception e){
              song_infodao.update_count(song_info1.getSongid());
          }
        }


    }

    @Override
    public void count(User_song user_song) {
        song_infodao.count(user_song);

    }
}
