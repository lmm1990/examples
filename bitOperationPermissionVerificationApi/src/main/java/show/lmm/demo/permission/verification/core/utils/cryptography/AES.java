package show.lmm.demo.permission.verification.core.utils.cryptography;

/**
 * 描述
 *
 * @author 刘明明
 * @since 2022-02-17 11:28
 */

import lombok.extern.log4j.Log4j2;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

/**
 * aes加密
 * @author 刘明明
 */
@Log4j2
public class AES {

    /**
     * 默认的加密算法
     */
    private static final String DEFAULT_CIPHER_ALGORITHM = "AES/ECB/PKCS5Padding";
    public static final Charset CHAR_SET = Charset.forName("utf-8");

    /**
     * AES 加密操作
     *
     * @param content 待加密内容
     * @param key     加密秘钥
     * @return 返回Base64转码后的加密数据
     */
    public static String encrypt(String content, String key) {
        try {
            byte[] raw = key.getBytes(CHAR_SET);
            SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
            //"算法/模式/补码方式"
            Cipher cipher = Cipher.getInstance(DEFAULT_CIPHER_ALGORITHM);
            cipher.init(Cipher.ENCRYPT_MODE, skeySpec);
            byte[] encrypted = cipher.doFinal(content.getBytes(CHAR_SET));
            //此处使用BASE64做转码功能，同时能起到2次加密的作用。
            return Base64Utils.encode(encrypted);
        } catch (Exception e) {
            log.error("aes.encrypt error", e);
            return "";
        }
    }

    /**
     * AES 解密操作
     *
     * @param content
     * @param key     加密秘钥
     * @return
     */
    public static String decrypt(String content, String key) {
        try {
            //先用base64解密
            byte[] encrypted1 = Base64Utils.decodeToByteArray(content.getBytes(CHAR_SET));
            byte[] raw = key.getBytes(StandardCharsets.UTF_8);
            SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
            Cipher cipher = Cipher.getInstance(DEFAULT_CIPHER_ALGORITHM);
            cipher.init(Cipher.DECRYPT_MODE, skeySpec);

            byte[] original = cipher.doFinal(encrypted1);
            String originalString = new String(original, "utf-8");
            return originalString;
        } catch (Exception e) {
            log.error("aes.decrypt error", e);
            return "";
        }
    }


    /**
     * AES 加密操作
     *
     * @param content 待加密内容
     * @param key     加密秘钥
     * @return 返回Base64转码后的加密数据
     */
    public static String urlSafeEncrypt(String content, String key) {
        try {
            byte[] raw = key.getBytes(CHAR_SET);
            SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
            //"算法/模式/补码方式"
            Cipher cipher = Cipher.getInstance(DEFAULT_CIPHER_ALGORITHM);
            cipher.init(Cipher.ENCRYPT_MODE, skeySpec);
            byte[] encrypted = cipher.doFinal(content.getBytes(CHAR_SET));
            //此处使用BASE64做转码功能，同时能起到2次加密的作用。
            return Base64Utils.urlSafeEncode(encrypted);
        } catch (Exception e) {
            log.error("aes.encrypt error", e);
            return "";
        }
    }

    /**
     * AES 解密操作
     *
     * @param content
     * @param key     加密秘钥
     * @return
     */
    public static String urlSafeDecrypt(String content, String key) {
        if(content.isEmpty()){
            return "";
        }
        try {
            //先用base64解密
            byte[] encrypted1 = Base64Utils.urlSafeDecodeToByte(content);
            byte[] raw = key.getBytes(StandardCharsets.UTF_8);
            SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
            Cipher cipher = Cipher.getInstance(DEFAULT_CIPHER_ALGORITHM);
            cipher.init(Cipher.DECRYPT_MODE, skeySpec);

            byte[] original = cipher.doFinal(encrypted1);
            String originalString = new String(original, "utf-8");
            return originalString;
        } catch (Exception e) {
            log.error("aes.decrypt error", e);
            return "";
        }
    }
}