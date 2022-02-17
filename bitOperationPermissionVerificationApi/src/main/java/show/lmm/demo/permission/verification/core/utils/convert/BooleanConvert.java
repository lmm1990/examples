package show.lmm.demo.permission.verification.core.utils.convert;

/**
 * object转boolean
 *
 * @author liumingming
 */
public class BooleanConvert implements IConvert<Boolean> {

    /***
     * object转boolean
     *
     * @param value:        值
     * @param defaultValue: 默认值
     * @return java.lang.Long
     **/
    @Override
    public Boolean cast(Object value, Boolean defaultValue) {
        if (value == null) {
            return defaultValue;
        }
        if (value instanceof Integer) {
            return (Boolean) value;
        }
        try {
            return Boolean.parseBoolean(value.toString());
        } catch (Exception e) {
            return defaultValue;
        }
    }

    /***
     * object转boolean
     *
     * @param value:        值
     * @return java.lang.Long
     **/
    @Override
    public Boolean cast(Object value) {
        return cast(value, false);
    }
}
