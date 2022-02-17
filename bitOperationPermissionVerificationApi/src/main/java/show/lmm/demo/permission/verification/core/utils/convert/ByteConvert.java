package show.lmm.demo.permission.verification.core.utils.convert;

/**
 * object转byte
 *
 * @author liumingming
 */
public class ByteConvert implements IConvert<Byte>{

    /***
     * object转byte
     *
     * @param value:        值
     * @param defaultValue: 默认值
     * @return java.lang.Long
     **/
    @Override
    public Byte cast(Object value, Byte defaultValue) {
        if (value == null) {
            return defaultValue;
        }
        if (value instanceof Integer) {
            return (Byte) value;
        }
        try {
            return Byte.parseByte(value.toString());
        } catch (Exception e) {
            return defaultValue;
        }
    }

    /***
     * object转byte
     *
     * @param value:        值
     * @return java.lang.Long
     **/
    @Override
    public Byte cast(Object value) {
        return cast(value, (byte) 0);
    }
}
