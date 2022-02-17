package show.lmm.demo.permission.verification.core;

import show.lmm.demo.permission.verification.core.conf.AppConfig;
import show.lmm.demo.permission.verification.core.constant.AuthConstant;
import show.lmm.demo.permission.verification.core.model.AuthData;
import show.lmm.demo.permission.verification.core.utils.TypeConvertUtils;
import show.lmm.demo.permission.verification.core.utils.cryptography.AES;

import javax.servlet.http.HttpServletRequest;

/**
 * token提供者
 * @author 刘明明
 * @since 2022-02-17 11:33:33
 */
public class TokenProvider {

    /**
     * token过期时间(24h)
     */
    private static long validityInMilliseconds = 24 * 60 * 60 * 1000;

    /**
     * 分隔符
     */
    private static final String SPLITTER = "-";

    /**
     * 创建token
     *
     * @param userId: 用户id
     * @return java.lang.String
     * @since 刘明明/2022-02-17 11:40:56
     **/
    public static String createToken(long userId) {
        long validity = System.currentTimeMillis() + validityInMilliseconds;
        String token = validity + SPLITTER + userId;
        return AES.urlSafeEncrypt(token, AppConfig.TOKEN_PWD);
    }

    /**
     * 初始化权限数据
     *
     * @param request: http请求
     * @since 刘明明/2022-02-17 11:41:44
     **/
    public static void initAuthData(HttpServletRequest request) {
        String token = request.getHeader(AuthConstant.AUTHORIZATION);
        if (token == null || token.isEmpty()) {
            token = request.getParameter(AuthConstant.AUTHORIZATION);
        }
        if (token == null || token.isEmpty()) {
            return;
        }
        String[] tokenItems = AES.urlSafeDecrypt(token, AppConfig.TOKEN_PWD).split(SPLITTER);
        if (TypeConvertUtils.toLong(tokenItems[0], 0) < System.currentTimeMillis()) {
            return;
        }
        long userId =  TypeConvertUtils.toLong(tokenItems[1], 0);
        DataHandler.authThreadLocal.set(new AuthData.Builder(userId).build());
    }

    public static void main(String[] args) {
        System.out.println(createToken(1));
    }
}
