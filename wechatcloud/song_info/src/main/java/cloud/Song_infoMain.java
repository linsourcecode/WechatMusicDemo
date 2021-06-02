package cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class Song_infoMain {
    public static void main(String[] args) {
        SpringApplication.run(Song_infoMain.class, args);}
}
