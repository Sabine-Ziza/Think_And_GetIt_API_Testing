package payload;

import lombok.Data;

@Data
public class CartPojo {
    private String productId;
    private Integer quantity;
    private String variantId;
}
