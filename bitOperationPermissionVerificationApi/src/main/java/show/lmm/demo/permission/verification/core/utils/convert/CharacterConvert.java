package show.lmm.demo.permission.verification.core.utils.convert;

/**
 * object转char
 *
 * @author liumingming
 */
public class CharacterConvert implements IConvert<Character>{

    /***
     * object转char
     *
     * @param value:        值
     * @param defaultValue: 默认值
     * @return java.lang.Long
     **/
    @Override
    public Character cast(Object value, Character defaultValue) {
        if (value == null) {
            return defaultValue;
        }
        if (value instanceof Integer) {
            return (Character) value;
        }
        try {
            return value.toString().charAt(0);
        } catch (Exception e) {
            return defaultValue;
        }
    }

    /***
     * object转char
     *
     * @param value:        值
     * @return java.lang.Long
     **/
    @Override
    public Character cast(Object value) {
        return cast(value, ' ');
    }
}
