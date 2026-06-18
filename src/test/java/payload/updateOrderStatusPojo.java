package payload;

import lombok.Data;

@Data
public class updateOrderStatusPojo {

        private String status;
        private String message;
        private String trackingNumber;

}
