package payload;

import lombok.Data;

@Data
public class Pagination {
    private int page;
    private int limit;
    private int total;
    private int pages;
}
