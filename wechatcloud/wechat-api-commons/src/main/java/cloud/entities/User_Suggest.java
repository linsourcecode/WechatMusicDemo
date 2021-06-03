package cloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User_Suggest {
    private BigInteger id;
    private String email;
    private String suggest;
}
