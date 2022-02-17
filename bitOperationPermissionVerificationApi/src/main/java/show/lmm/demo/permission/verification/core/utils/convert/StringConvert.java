package show.lmm.demo.permission.verification.core.utils.convert;

/**
 * object转string
 *
 * @author liumingming
 */
public class StringConvert implements IConvert<String>{

    /**
     * object转string
     *
     * @param value:        值
     * @param defaultValue: 默认值
     * @return java.lang.Short
     **/
    @Override
    public String cast(Object value, String defaultValue) {
        if (value == null) {
            return defaultValue;
        }
        return value.toString();
    }

    /**
     * object转short
     *
     * @param value: 值
     * @return java.lang.Short
     **/
    @Override
    public String cast(Object value) {
        return cast(value, "");
    }
}
