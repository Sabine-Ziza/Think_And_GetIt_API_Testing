package payload;

import lombok.Data;

@Data
public class OrderPojo {
    private String addressId;
    private String paymentMethod;
    private String notes;
    private int shippingFee;
    private String reason;
}
