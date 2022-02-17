package show.lmm.demo.permission.verification.core;

import show.lmm.demo.permission.verification.core.model.AuthData;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * 公共数据
 *
 * @author 刘明明
 * @since 2022-02-17 10:42:00
 */
public class DataHandler {

    /**
     * 用户角色map[用户id，list<角色id>]
     */
    public static Map<Long, Collection<Integer>> userRoleList = new HashMap<>(){{
        put(1L,new ArrayList<>(){{
            add(1);
        }});
    }};

    /**
     * 角色页面权限map[角色id_页面id,权限]
     */
    public static Map<String, Integer> rolePageRightMap = new HashMap<>(){{
        put("1_1",60);
    }};

    /**
     * 身份验证数据
     */
    public static ThreadLocal<AuthData> authThreadLocal = new ThreadLocal<>();

    /**
     * 获得身份信息
     *
     * @return show.lmm.demo.permission.verification.core.model.AuthData
     * @since 刘明明/2022-02-17 10:43:49
     **/
    public static AuthData getAuthData() {
        return authThreadLocal.get();
    }

    /**
     * 获得身份id
     *
     * @return long
     * @since 刘明明/2022-02-17 10:44:01
     **/
    public static long getAuthUserId() {
        AuthData authData = getAuthData();
        if (authData == null) {
            return 0;
        }
        return authData.getUserId();
    }
}
