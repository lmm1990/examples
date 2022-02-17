package show.lmm.demo.permission.verification.core.utils.convert;

/**
 * 类型转换接口
 *
 * @author liumingming
 */
public interface IConvert<T> {

    /**
     * 类型转换
     *
     * @param value:        值
     * @param defaultValue: 默认值
     * @return T
     **/
    T cast(Object value, T defaultValue);

    /**
     * 类型转换
     *
     * @param value: 值
     * @return T
     **/
    T cast(Object value);
}
