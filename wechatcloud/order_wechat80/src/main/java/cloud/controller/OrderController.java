package cloud.controller;

import cloud.entities.CommonResult;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
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

    //public static final String PAYMENT_URL = "http://CLOUD-PAYMENT-SERVICE";

    @Resource
    private RestTemplate restTemplate;
/**
    @Resource
    private LoadBalancer loadBalancer;
    @Resource
    private DiscoveryClient discoveryClient;
**/
    @PostMapping(value = "/consumer/payment/create{id}")
    public CommonResult  create(@PathVariable("id") long id)
    {
        System.out.println("数据为"+id);

        return restTemplate.getForObject(PAYMENT_URL +"/login/"+id, CommonResult.class);
    }


    }


