package show.lmm.demo.permission.verification.core.utils.convert;

/**
 * object转float
 *
 * @author liumingming
 */
public class FloatConvert implements IConvert<Float>{

    /**
     * object转float
     *
     * @param value:        值
     * @param defaultValue: 默认值
     * @return java.lang.Float
     **/
    @Override
    public Float cast(Object value, Float defaultValue) {
        if (value == null) {
            return defaultValue;
        }
        if (value instanceof Integer) {
            return (Float) value;
        }
        try {
            return Float.parseFloat(value.toString());
        } catch (Exception e) {
            return defaultValue;
        }
    }

    /**
     * object转float
     *
     * @param value: 值
     * @return java.lang.Float
     **/
    @Override
    public Float cast(Object value) {
        return cast(value, 0f);
    }
}
