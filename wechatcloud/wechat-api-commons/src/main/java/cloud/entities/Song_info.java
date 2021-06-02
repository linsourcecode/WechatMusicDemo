package cloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Song_info {
    private long id;
    private long songid;
    private int play_time;
    private int play_score;
    private String songname;

}
