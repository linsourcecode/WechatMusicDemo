package cloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Song_info {

    private BigInteger songid;
    private String singer;
    private Integer score;
    private String songname;
    private  Integer play_time;

}
