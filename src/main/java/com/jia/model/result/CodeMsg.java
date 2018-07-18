package com.jia.model.result;

/**
 * @Auther: jia
 * @Date: 2018/7/18 16:02
 * @Description: 返回码
 */
public class CodeMsg {

    private int code;

    private String message;

    //成功返回
    public static CodeMsg SUCCESS = new CodeMsg(0,"success");

    // 通用异常
    public static CodeMsg SERVER_EXCEPTION = new CodeMsg(500100,"服务端异常");
    public static CodeMsg PARAMETER_ISNULL = new CodeMsg(500101,"输入参数为空");

    // 业务异常
    public static CodeMsg USER_NOT_EXIST = new CodeMsg(500102,"用户不存在");
    public static CodeMsg ONLINE_USER_OVER = new CodeMsg(500103,"在线用户数超出允许登录的最大用户限制。");
    public static CodeMsg SESSION_NOT_EXIST =  new CodeMsg(500104,"不存在离线session数据");

    public CodeMsg(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
