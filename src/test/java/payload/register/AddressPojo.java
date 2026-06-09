package payload.register;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data

@JsonIgnoreProperties(ignoreUnknown = true)
public class AddressPojo {
//    private String address;
//    private String street;
//    private String city;
//    private String state;
//    private String country;
//    private String postalCode;
//
//    private String email;
    private String firstName;
//    private String lastName;
//    private String password;
//    private String phone;
//    private String userId;
//
//    private String label;
//    private Boolean isDefault;

    private String street;
    private String city;
    private String state;
    private String country;
    private String postalCode;

//    private String email;
//    private String firstName;
//    private String lastName;
//    private String password;
//    private String phone;

    private String userId;
    private String label;
    private Boolean isDefault;

    // getters and setters
}




