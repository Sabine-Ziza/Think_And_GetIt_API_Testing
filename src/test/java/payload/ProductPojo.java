package payload;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProductPojo {

    private String name;
    private String description;
    private double price;
    private double comparePrice;
    private String categoryId;
//    private String productId;
}
