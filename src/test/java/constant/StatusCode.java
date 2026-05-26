package constant;

public enum StatusCode {
    CODE_200(200, " "),
    CODE_201(201, " "),
    CODE_400(400, " "),
    CODE_404(404, " "),
    CODE_401(401, " ");

    private final int code;
    private final String msg;

    StatusCode(int code, String msg) {
        this.code = code;
        this.msg = msg;

    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
