package cloud.controller;

import cloud.entities.CommonResult;

import cloud.service.loginFeginService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

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


    }


