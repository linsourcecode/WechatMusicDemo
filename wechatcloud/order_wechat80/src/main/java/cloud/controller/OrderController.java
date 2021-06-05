package cloud.controller;

import cloud.entities.CommonResult;

import cloud.entities.Play_Song;
import cloud.entities.User_Suggest;
import cloud.service.SongFeginService;
import cloud.service.loginFeginService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.math.BigInteger;

/**
 * @auther zzyy
 * @create 2020-02-18 17:23
 */
@RestController
@Slf4j
public class OrderController
{
    public static final String PAYMENT_URL = "http://localhost:8001";
    public static final String INVOKE_URL = "http://user-login-service";
    @Resource
    private loginFeginService loginFeginService;
    @Resource
    private SongFeginService songFeginService;

    //public static final String PAYMENT_URL = "http://CLOUD-PAYMENT-SERVICE";

    @Resource
    private RestTemplate restTemplate;
/**
    @Resource
    private LoadBalancer loadBalancer;
    @Resource
    private DiscoveryClient discoveryClient;
**/
    @RequestMapping( "/login/{id}")
    public CommonResult  create(@PathVariable("id") long id)
    {
        System.out.println("数据为"+id);

        return restTemplate.getForObject(INVOKE_URL +"/login/"+id, CommonResult.class);
    }
    @RequestMapping( "/add/{id}")
    public CommonResult  count(@PathVariable("id") long id)
    {
        System.out.println("数据为"+id);

        return loginFeginService.post(id);
    }
    //记录播放信息
    @RequestMapping( "/songrecord/{id}")
    public CommonResult  count(@PathVariable("id") BigInteger userid)
    {
        System.out.println("数据为"+userid);


        return  songFeginService.post(userid);


    }
    @RequestMapping("/suggest")
    public void test(@RequestBody User_Suggest user_suggest){

        loginFeginService.run(user_suggest);

    }
    @ResponseBody
    @RequestMapping("/test")
    public void test(@RequestBody Play_Song play_song){
        log.error(String.valueOf(play_song));
        songFeginService.test(play_song);
    }


}


