package cloud.service;

import cloud.entities.CommonResult;
import cloud.entities.Play_Song;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.math.BigInteger;

@Component
@FeignClient(value = "song-info-service")
public interface SongFeginService {
    @RequestMapping(value="/songinfo/{id}")
    CommonResult post(@PathVariable("id") BigInteger userid);
    @ResponseBody
    @RequestMapping("/test")
    public void test(@RequestBody Play_Song play_song);
}
