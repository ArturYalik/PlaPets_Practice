package models;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Builder
@ToString

public class UserModel {

    private String name;
    private String email;
    private String password;
    private String confirmPassword;
}
