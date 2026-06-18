package payload;

import lombok.Data;

@Data
public class CouponRequest {
    private String code;
    private String description;
    private String discountType;
    private double discountValue;
    private double minOrderAmount;
    private int maxUses;
    private String expiresAt;


}
