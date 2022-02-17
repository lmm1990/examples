package show.lmm.demo.permission.verification.core.utils;

import show.lmm.demo.permission.verification.core.model.PermissionEnum;

/**
 * 权限验证工具类
 *
 * @author 刘明明
 * @since 2022-02-17 09:54:19
 */
public class PermissionUtils {

    /**
     * 基础权限，该数字可以是一个范围
     */
    public static int base = 1;

    /**
     * 增加权限
     *
     * @param permission: 原权限
     * @param operate:    需要增加的权限
     * @return int 最终权限值
     * @since 刘明明/2022-02-17 09:56:54
     **/
    public static int addPermission(int permission, PermissionEnum operate) {
        int per = base << operate.getId();
        //增加权限时使用或，可以将权限对应的二进制位的1赋值给权限变量的0
        permission |= per;
        return permission;
    }

    /**
     * 删除权限
     *
     * @param permission: 原权限
     * @param operate:    需要增加的权限
     * @return int 最终权限值
     * @since 刘明明/2022-02-17 09:57:00
     **/
    public static int delPermission(int permission, PermissionEnum operate) {
        int per = base << operate.getId();
        // 按位取反，取反之前的1，取反后变为0，再和权限数字进行与运算，1&0=0,1&1=1，0&1=0，这样删除对应权限，并且不影响原有权限
        per = ~per;
        return permission & per;
    }

    /**
     * 验证是否有权限
     *
     * @param permission: 权限值
     * @param operate:    权限
     * @return boolean 是否有权限
     * @since 刘明明/2022-02-17 09:58:49
     **/
    public static boolean hasPermission(int permission, PermissionEnum operate) {
        int per = base << operate.getId();
        // 1&0=0;1&1=1;0&1=0; permission和per&操作之后，如果permission对应的位为1，则和per&的结果就等于per
        return (permission & per) == per;
    }
}
