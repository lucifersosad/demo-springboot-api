package spring.security.demonht.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserModel {
    private String userName;
    private String role;
    private String email;
    private boolean _isActive;
}
