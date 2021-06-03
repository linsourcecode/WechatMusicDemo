package cloud.controller;





import cloud.entities.Song_info;
import cloud.entities.User_song;
import cloud.service.impl.Song_info_service_info;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.net.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@RestController
@Slf4j
public class Song_infoController {
    @Resource
    private Song_info_service_info song_info_service_info;
    @RequestMapping("/songinfo/{id}")
    public void save(@PathVariable("id") BigInteger userid) throws IOException {

        String ur = "http://localhost:3000/user/record?uid=1495025170&type=1";

        URI uri = URI.create(ur);
        URL url = uri.toURL();
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod(HttpMethod.POST.name());
        connection.setDoOutput(true);
        connection.connect();
        InputStream inputStream = connection.getInputStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        //System.out.println(reader.readLine());
        JSONArray list = new JSONArray();
        //list = JSONArray.parseArray(reader.toString());
        JSONObject jsonObject=JSONObject.parseObject(reader.readLine());
       // String code = jsonObject.getString("weekData");
       // System.out.println(code);
        list = jsonObject.getJSONArray("weekData");
        List<Song_info> song_infos=new ArrayList<>();
        // 遍历JSONArray
        for (Iterator<Object> iterator = list.iterator(); iterator.hasNext(); ) {
            JSONObject next = (JSONObject) iterator.next();
            //System.err.println("a ===>>> " + next.getString("song"));
            String songinfo = next.getString("song");
            Integer playCount = next.getInteger("playCount");
            Integer scores = next.getInteger("score");

            JSONObject jsonObject1=JSONObject.parseObject(songinfo);

            String name= jsonObject1.getString("name");
            System.out.println("************"+jsonObject1.getBigInteger("id"));
            BigInteger songid = jsonObject.getBigInteger("id");
            String ar= jsonObject1.getString("ar");
            System.out.println("************"+ar+name+" "+scores+playCount+songid);

            JSONArray jsonArray=JSONArray.parseArray(ar);

            System.out.println(jsonArray.getString(0));
            //String artis = jsonObject2.getString("name");
            //System.out.println("a========>"+artis+"=="+songid);
            String line= jsonArray.getString(0);
            JSONObject jsonObject2=JSONObject.parseObject(line);
            System.out.println(jsonObject2.getString("name"));
            String singer=jsonObject2.getString("name");

            Song_info song_info=new Song_info();
            song_info.setSongid(jsonObject1.getBigInteger("id"));
            song_info.setSongname(name);
            song_info.setScore(scores);
            song_info.setPlay_time(playCount);
            song_info.setSinger(singer);
            song_infos.add(song_info);
            System.out.println(song_info.toString());


        }
        song_info_service_info.save_user_info(song_infos);




    }
    @ResponseBody
    @RequestMapping("/countsong/{songid}/{userid}")
    public void count_song(@PathVariable BigInteger songid,@PathVariable BigInteger userid) {
    //,@RequestParam(value = "songid") BigInteger songid
        //@PathVariable("userid") BigInteger userid
    }
    @ResponseBody
    @RequestMapping("/test")
    public void test(@RequestBody Song_info song_info) {
        System.out.println(song_info.toString());
    }

}
