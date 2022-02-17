package show.lmm.demo.permission.verification.core.utils;

import show.lmm.demo.permission.verification.core.utils.convert.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

/**
 * 类型转换工具类
 *
 * @author 刘明明
 */
public class TypeConvertUtils {

    private static final Logger log = LogManager.getLogger(TypeConvertUtils.class);

    private static final Map<String, Map<String, Method>> methodMap = new HashMap<>();

    /**
     * 类型转换方法map
     */
    private static final Map<Class<?>, IConvert> convertMethodMap = new HashMap<Class<?>, IConvert>() {{
        put(int.class, new IntegerConvert());
        put(long.class, new LongConvert());
        put(byte.class, new ByteConvert());
        put(short.class, new ShortConvert());
        put(float.class, new FloatConvert());
        put(double.class, new DoubleConvert());
        put(boolean.class, new BooleanConvert());
        put(char.class, new CharacterConvert());
        put(String.class, new StringConvert());
    }};


    /**
     * map转对象
     *
     * @param data:        数据源
     * @param targetClass: 转换后的类型
     * @return T
     **/
    public static <T> T mapToObject(Map<String, Object> data, Class<T> targetClass) {
        String className = targetClass.getName();
        if (!methodMap.containsKey(className)) {
            methodMap.put(className, new HashMap<>());
        }
        for (Method method : targetClass.getMethods()) {
            if (method.getName().startsWith("set")) {
                methodMap.get(className).put(method.getName(), method);
            }
        }

        try {
            T info = targetClass.getDeclaredConstructor().newInstance();
            Set<Map.Entry<String, Object>> entrys = data.entrySet();
            String setMethodName;
            for (Map.Entry<String, Object> item : entrys) {
                if (item.getKey().startsWith("_")) {
                    log.debug(String.format("字段：%s，跳过赋值", item.getKey()));
                    continue;
                }
                setMethodName = getSetMethodName(item.getKey());
                if (!methodMap.get(className).containsKey(setMethodName)) {
                    throw new RuntimeException(String.format("字段：%s，赋值失败", item.getKey()));
                }
                methodMap.get(className).get(setMethodName).invoke(info, item.getValue());
            }
            return info;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 获得设置方法名称
     *
     * @param baseName: 原始方法名
     * @return java.lang.String
     **/
    private static String getSetMethodName(String baseName) {
        String[] nameList = baseName.split("_");
        StringBuilder finalMethodName = new StringBuilder("set");
        for (int i = 0, length = nameList.length; i < length; i++) {
            finalMethodName.append(nameList[i].substring(0, 1).toUpperCase(Locale.ROOT));
            finalMethodName.append(nameList[i].substring(1));
        }
        return finalMethodName.toString();
    }

    /**
     * 类型转换
     *
     * @param value:        值
     * @param defaultValue: 默认值
     * @param targetClass:  转换目标类型
     * @return T
     **/
    public static <T> T cast(Object value, T defaultValue, Class<T> targetClass) {
        if (!convertMethodMap.containsKey(targetClass)) {
            throw new RuntimeException(String.format("暂不支持 %s 类型转换", targetClass.getName()));
        }
        return (T) convertMethodMap.get(targetClass).cast(value, defaultValue);
    }

    /**
     * 类型转换
     *
     * @param value:       值
     * @param targetClass: 转换目标类型
     * @return T
     **/
    private static <T> T cast(Object value, Class<T> targetClass) {
        if (!convertMethodMap.containsKey(targetClass)) {
            throw new RuntimeException(String.format("暂不支持 %s 类型转换", targetClass.getName()));
        }
        return (T) convertMethodMap.get(targetClass).cast(value);
    }

    /**
     * object转int
     *
     * @param value:        值
     * @param defaultValue: 默认值
     * @return int
     **/
    public static int toInt(Object value, int defaultValue) {
        return cast(value, defaultValue, int.class);
    }

    /**
     * object转int
     *
     * @param value: 值
     * @return int
     **/
    public static int toInt(Object value) {
        return cast(value, int.class);
    }

    /**
     * object转long
     *
     * @param value:        值
     * @param defaultValue: 默认值
     * @return java.lang.Long
     **/
    public static Long toLong(Object value, long defaultValue) {
        return cast(value, defaultValue, long.class);
    }

    /**
     * object转long
     *
     * @param value: 值
     * @return java.lang.Long
     **/
    public static Long toLong(Object value) {
        return cast(value, long.class);
    }

    /***
     * object转byte
     *
     * @param value:        值
     * @param defaultValue: 默认值
     * @return java.lang.Long
     **/
    public static Byte toByte(Object value, byte defaultValue) {
        return cast(value,defaultValue,byte.class);
    }

    /***
     * object转byte
     *
     * @param value:        值
     * @return java.lang.Long
     **/
    public static Byte toByte(Object value) {
        return cast(value,byte.class);
    }

    /**
     * object转short
     *
     * @param value:        值
     * @param defaultValue: 默认值
     * @return java.lang.Short
     **/
    public static Short toShort(Object value, short defaultValue) {
        return cast(value,defaultValue,short.class);
    }

    /**
     * object转short
     *
     * @param value: 值
     * @return java.lang.Short
     **/
    public static Short toShort(Object value) {
        return cast(value,short.class);
    }

    /**
     * object转float
     *
     * @param value:        值
     * @param defaultValue: 默认值
     * @return java.lang.Float
     **/
    public static Float toFloat(Object value, float defaultValue) {
        return cast(value,defaultValue,float.class);
    }

    /**
     * object转float
     *
     * @param value: 值
     * @return java.lang.Float
     **/
    public static Float toFloat(Object value) {
        return cast(value,float.class);
    }

    /**
     * object转double
     *
     * @param value:        值
     * @param defaultValue: 默认值
     * @return java.lang.Float
     *
     **/
    public static double toDouble(Object value, double defaultValue) {
        return cast(value,defaultValue,double.class);
    }

    /**
     * object转double
     *
     * @param value: 值
     * @return java.lang.Float
     **/
    public static double toDouble(Object value) {
        return cast(value,double.class);
    }

    /**
     * object转boolean
     *
     * @param value:        值
     * @param defaultValue: 默认值
     * @return java.lang.Float
     *
     **/
    public static boolean toBoolean(Object value, boolean defaultValue) {
        return cast(value,defaultValue,boolean.class);
    }

    /**
     * object转double
     *
     * @param value: 值
     * @return java.lang.Float
     **/
    public static boolean toBoolean(Object value) {
        return cast(value,boolean.class);
    }

    /**
     * object转char
     *
     * @param value:        值
     * @param defaultValue: 默认值
     * @return java.lang.Float
     *
     **/
    public static char toChar(Object value, char defaultValue) {
        return cast(value,defaultValue,char.class);
    }

    /**
     * object转char
     *
     * @param value: 值
     * @return java.lang.Float
     **/
    public static char toChar(Object value) {
        return cast(value,char.class);
    }

    /**
     * object转String
     *
     * @param value:        值
     * @param defaultValue: 默认值
     * @return String
     **/
    public static String toString(Object value, String defaultValue) {
        return cast(value, defaultValue, String.class);
    }

    /**
     * object转String
     *
     * @param value: 值
     * @return String
     **/
    public static String toString(Object value) {
        return cast(value, String.class);
    }
}
