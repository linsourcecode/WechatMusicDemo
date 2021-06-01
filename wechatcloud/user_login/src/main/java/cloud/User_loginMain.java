package cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


@SpringBootApplication
@EnableDiscoveryClient
public class User_loginMain {
    public static void main(String[] args) {
        SpringApplication.run(User_loginMain.class, args);}
}
