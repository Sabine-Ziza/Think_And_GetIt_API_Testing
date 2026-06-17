package payload.register;

import lombok.Data;

@Data

public class RegisterPOJO {
    private String email;
    private String firstName;
    private String lastName;
    private String password;
    private String address;
    private String phone;
    private String street;
    private String city;
    private String state;
    private String country;
    private String postalCode;
}
