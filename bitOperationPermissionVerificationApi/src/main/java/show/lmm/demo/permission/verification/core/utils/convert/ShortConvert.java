package show.lmm.demo.permission.verification.core.utils.convert;

/**
 * object转short
 *
 * @author liumingming
 */
public class ShortConvert implements IConvert<Short>{

    /**
     * object转short
     *
     * @param value:        值
     * @param defaultValue: 默认值
     * @return java.lang.Short
     **/
    @Override
    public Short cast(Object value, Short defaultValue) {
        if (value == null) {
            return defaultValue;
        }
        if (value instanceof Integer) {
            return (Short) value;
        }
        try {
            return Short.parseShort(value.toString());
        } catch (Exception e) {
            return defaultValue;
        }
    }

    /**
     * object转short
     *
     * @param value: 值
     * @return java.lang.Short
     **/
    @Override
    public Short cast(Object value) {
        return cast(value, (short) 0);
    }
}
