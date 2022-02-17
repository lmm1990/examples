package show.lmm.demo.permission.verification.core.utils.convert;

/**
 * object转double
 *
 * @author liumingming
 */
public class DoubleConvert implements IConvert<Double>{

    /**
     * object转double
     *
     * @param value:        值
     * @param defaultValue: 默认值
     * @return java.lang.Float
     **/
    @Override
    public Double cast(Object value, Double defaultValue) {
        if (value == null) {
            return defaultValue;
        }
        if (value instanceof Integer) {
            return (Double) value;
        }
        try {
            return Double.parseDouble(value.toString());
        } catch (Exception e) {
            return defaultValue;
        }
    }

    /**
     * object转double
     *
     * @param value: 值
     * @return java.lang.Float
     **/
    @Override
    public Double cast(Object value) {
        return cast(value, 0D);
    }
}
