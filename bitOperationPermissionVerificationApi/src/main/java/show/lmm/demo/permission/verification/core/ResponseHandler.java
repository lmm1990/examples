package show.lmm.demo.permission.verification.core;

import lombok.Data;

/**
 * response返回值
 *
 * @author 刘明明
 * @since 2022-02-17 11:21
 */
@Data
public class ResponseHandler<T> {

    /**
     * 状态码
     */
    private int code;

    /**
     * 提示消息
     */
    private String msg;

    /**
     * 返回数据
     */
    private T data;

    /**
     * 页面权限值
     */
    private int pagePermissionValue;

    private ResponseHandler() {
    }

    public ResponseHandler(T data) {
        this.code = 0;
        this.data = data;
    }

    /**
     * 返回成功
     *
     * @param data:  数据
     * @return show.lmm.demo.permission.verification.core.ResponseHandler<T>
     * @since 刘明明/2022-02-17 11:24:25
     **/
    public static <T> ResponseHandler<T> success(T data) {
        return new ResponseHandler<>(data);
    }

    /**
     * 返回成功
     *
     * @return show.lmm.demo.permission.verification.core.ResponseHandler<java.lang.Boolean>
     * @since 刘明明/2022-02-17 11:24:16
     **/
    public static ResponseHandler<Boolean> success() {
        return new ResponseHandler<>(true){{
            setMsg("Success");
        }};
    }

    /**
     * 返回失败
     *
     * @param msg:  错误信息
     * @return show.lmm.demo.permission.verification.core.ResponseHandler<java.lang.Boolean>
     * @since 刘明明/2022-02-17 11:23:50
     **/
    public static ResponseHandler<Boolean> error(String msg) {
        return error(202, msg);
    }

    /**
     * 返回失败
     *
     * @param msg: 错误信息
     * @param args:  参数
     * @return show.lmm.demo.permission.verification.core.ResponseHandler<java.lang.Boolean>
     * @since 刘明明/2022-02-17 11:23:36
     **/
    public static ResponseHandler<Boolean> error(String msg, Object... args) {
        return error(String.format(msg, args));
    }

    /**
     * 返回失败
     *
     * @param code: 错误码
     * @param msg:  错误信息
     * @return show.lmm.demo.permission.verification.core.ResponseHandler<java.lang.Boolean>
     * @since 刘明明/2022-02-17 11:23:11
     **/
    public static ResponseHandler<Boolean> error(int code, String msg) {
        return new ResponseHandler<Boolean>() {{
            setCode(code);
            setMsg(msg);
        }};
    }

    /**
     * 设置权限值
     *
     * @param pagePermissionValue:  权限值
     * @return show.lmm.demo.permission.verification.core.ResponseHandler<T>
     * @since 刘明明/2022-02-17 11:22:54
     **/
    public ResponseHandler<T> setPagePermissionValue(int pagePermissionValue) {
        this.pagePermissionValue = pagePermissionValue;
        return this;
    }
}
