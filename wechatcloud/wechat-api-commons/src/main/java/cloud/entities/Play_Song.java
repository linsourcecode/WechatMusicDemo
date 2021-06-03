package cloud.entities;

import cn.hutool.core.date.DateTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Play_Song {
    private BigInteger songid;
    private String singer;
    private Integer score;
    private String songname;
    private Integer play_time;
    private BigInteger id;
    DateTime datetime;
}
