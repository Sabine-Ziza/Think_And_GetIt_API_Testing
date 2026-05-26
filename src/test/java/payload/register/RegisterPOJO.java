package payload.register;

import lombok.Data;

@Data
public class RegisterPOJO {
    private String email;
    private String firstName;
    private String lastName;
    private String password;
}
