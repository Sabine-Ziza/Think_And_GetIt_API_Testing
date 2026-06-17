package payload;

import lombok.Data;

@Data
public class ChangePasswordPojo {
    private String newPassword;
    private String currentPassword;
}
