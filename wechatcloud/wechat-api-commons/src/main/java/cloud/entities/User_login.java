package cloud.entities;

import cn.hutool.core.date.DateTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User_login {
    long id;
    DateTime date;
    int rank;
    int time;

}
