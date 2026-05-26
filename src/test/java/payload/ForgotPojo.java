package payload;

import lombok.Data;

@Data
public class ForgotPojo {
    private String email;
    private String token;
    private String newPassword;

}
