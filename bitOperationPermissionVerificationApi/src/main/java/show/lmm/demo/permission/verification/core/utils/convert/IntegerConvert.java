package show.lmm.demo.permission.verification.core.utils.convert;

/**
 * object转int
 *
 * @author liumingming
 */
public class IntegerConvert implements IConvert<Integer> {

    /***
     * object转int
     *
     * @param value:        值
     * @param defaultValue: 默认值
     **/
    @Override
    public Integer cast(Object value, Integer defaultValue) {
        if (value == null) {
            return defaultValue;
        }
        if (value instanceof Integer) {
            return (Integer) value;
        }
        try {
            return Integer.parseInt(value.toString());
        } catch (Exception e) {
            return defaultValue;
        }
    }

    /**
     * object转int
     *
     * @param value: 值
     **/
    @Override
    public Integer cast(Object value) {
        return cast(value, 0);
    }
}
