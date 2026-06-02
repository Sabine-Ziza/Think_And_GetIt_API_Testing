package payload;

import lombok.Data;

@Data
public class ProductPojo {

    private String name;
    private String description;
    private double price;
    private double comparePrice;
    private String categoryId;
}
