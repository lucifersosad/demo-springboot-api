package spring.security.demonht.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserModel {
    private String id;
    private String username;
    private String fName;
    private String gender;
    private String email;
    private String images;
}
