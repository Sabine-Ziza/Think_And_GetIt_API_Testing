package payload;

import lombok.Data;

import java.util.List;

@Data
public class SearchPojo {
    private boolean success;
    private String message;
    private List<Object> data;
    private Pagination pagination;
}
