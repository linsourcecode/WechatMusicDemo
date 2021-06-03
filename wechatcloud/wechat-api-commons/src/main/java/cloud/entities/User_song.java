package cloud.entities;

import cn.hutool.core.date.DateTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User_song {
    private BigInteger id;
    private BigInteger songid;
    DateTime datetime;

}
