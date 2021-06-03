package cloud.service;

import cloud.entities.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.math.BigInteger;

@Component
@FeignClient(value = "song-info-service")
public interface SongFeginService {
    @RequestMapping(value="/songinfo/{id}")
    CommonResult post(@PathVariable("id") BigInteger userid);
}
