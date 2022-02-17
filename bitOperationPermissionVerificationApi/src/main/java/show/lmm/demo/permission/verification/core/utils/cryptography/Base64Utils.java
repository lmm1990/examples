package show.lmm.demo.permission.verification.core.utils.cryptography;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

/**
 * Base64加解密
 *
 * @author 刘明明
 * @since 2022-02-17 11:29
 */
public class Base64Utils {

    /**
     * 加密
     *
     * @param data:  待加密数据
     * @return java.lang.String
     * @since 刘明明/2022-02-17 11:30:09
     **/
    public static String encode(String data) {
        return encode(data.getBytes(StandardCharsets.UTF_8));
    }

    /**
     * 加密
     *
     * @param data:  待加密数据
     * @return java.lang.String
     * @since 刘明明/2022-02-17 11:30:09
     **/
    public static String encode(byte[] data){
        return new String(encodeToByteArray(data),StandardCharsets.UTF_8);
    }

    /**
     * 加密后返回字节数组
     *
     * @param data:  待加密数据
     * @return java.lang.String
     * @since 刘明明/2022-02-17 11:30:09
     **/
    public static byte[] encodeToByteArray(String data){
        return Base64.getEncoder().encode(data.getBytes(StandardCharsets.UTF_8));
    }

    /**
     * 加密后返回字节数组
     *
     * @param data:  待加密数据
     * @return java.lang.String
     * @since 刘明明/2022-02-17 11:30:09
     **/
    public static byte[] encodeToByteArray(byte[] data){
        return Base64.getEncoder().encode(data);
    }

    /**
     * 解密
     *
     * @param data:  加密数据
     * @return java.lang.String
     * @since 刘明明/2022-02-17 11:30:09
     **/
    public static String decode(byte[] data){
        return new String(decodeToByteArray(data),StandardCharsets.UTF_8);
    }

    /**
     * 解密后返回字节数组
     *
     * @param data:  加密数据
     * @return java.lang.String
     * @since 刘明明/2022-02-17 11:30:09
     **/
    public static byte[] decodeToByteArray(byte[] data){
        return Base64.getDecoder().decode(data);
    }

    /**
     * 解密后返回字节数组
     *
     * @param data:  加密数据
     * @return java.lang.String
     * @since 刘明明/2022-02-17 11:30:09
     **/
    public static byte[] decodeToByteArray(String data){
        return decodeToByteArray(data.getBytes(StandardCharsets.UTF_8));
    }

    /**
     * url安全加密
     *
     * @param data:  待加密数据
     * @return java.lang.String
     * @since 刘明明/2022-02-17 11:30:09
     **/
    public static String urlSafeEncode(byte[] data){
        String encodeBase64 = encode(data);
        String safeBase64Str = encodeBase64.replace('+', '-');
        safeBase64Str = safeBase64Str.replace('/', '_');
        safeBase64Str = safeBase64Str.replaceAll("=", "");
        return safeBase64Str;
    }

    /**
     * url安全解密
     *
     * @param safeBase64Str:  加密数据
     * @return java.lang.String
     * @since 刘明明/2022-02-17 11:30:09
     **/
    public static String urlSafeDecode(final String safeBase64Str){
        String base64Str = safeBase64Str.replace('-', '+');
        base64Str = base64Str.replace('_', '/');
        int mod4 = base64Str.length()%4;
        if(mod4 > 0){
            base64Str = base64Str + "====".substring(mod4);
        }
        return decode(base64Str.getBytes(StandardCharsets.UTF_8));
    }

    /**
     * url安全解密返回字节数组
     *
     * @param safeBase64Str:  加密数据
     * @return java.lang.String
     * @since 刘明明/2022-02-17 11:30:09
     **/
    public static byte[] urlSafeDecodeToByte(final String safeBase64Str){
        String base64Str = safeBase64Str.replace('-', '+');
        base64Str = base64Str.replace('_', '/');
        int mod4 = base64Str.length()%4;
        if(mod4 > 0){
            base64Str = base64Str + "====".substring(mod4);
        }
        return decodeToByteArray(base64Str.getBytes(StandardCharsets.UTF_8));
    }
}