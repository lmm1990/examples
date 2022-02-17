package show.lmm.demo.permission.verification.core.utils.convert;

/**
 * object转long
 *
 * @author liumingming
 */
public class LongConvert implements IConvert<Long>{

    /**
     * object转long
     *
     * @param value:        值
     * @param defaultValue: 默认值
     * @return java.lang.Long
     **/
    @Override
    public Long cast(Object value, Long defaultValue) {
        if (value == null) {
            return defaultValue;
        }
        if (value instanceof Long) {
            return (Long) value;
        }
        try {
            return Long.parseLong(value.toString());
        } catch (Exception e) {
            return defaultValue;
        }
    }

    /**
     * object转long
     *
     * @param value: 值
     * @return java.lang.Long
     **/
    @Override
    public Long cast(Object value) {
        return cast(value,0L);
    }
}
