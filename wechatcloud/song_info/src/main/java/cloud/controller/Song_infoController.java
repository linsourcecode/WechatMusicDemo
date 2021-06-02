package cloud.controller;





import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.*;
import java.util.Iterator;

@RestController
@Slf4j
public class Song_infoController {
    @RequestMapping("/songinfo")
    public void save() throws IOException {

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
        // 遍历JSONArray
        for (Iterator<Object> iterator = list.iterator(); iterator.hasNext(); ) {
            JSONObject next = (JSONObject) iterator.next();
            //System.err.println("a ===>>> " + next.getString("song"));
            String songinfo = next.getString("song");
            Integer playCount = next.getInteger("playCount");
            Integer score = next.getInteger("score");

            JSONObject jsonObject1=JSONObject.parseObject(songinfo);

            String name= jsonObject1.getString("name");
            System.out.println("************"+name);
            Integer songid = jsonObject.getInteger("id");
            String ar= jsonObject1.getString("ar");
            System.out.println("************"+ar);

            JSONArray jsonArray=JSONArray.parseArray(ar);

            System.out.println(jsonArray.getString(0));
            //String artis = jsonObject2.getString("name");
            //System.out.println("a========>"+artis+"=="+songid);
            String line= jsonArray.getString(0);
            JSONObject jsonObject2=JSONObject.parseObject(line);
            System.out.println(jsonObject2.getString("name"));






        }




    }
}
