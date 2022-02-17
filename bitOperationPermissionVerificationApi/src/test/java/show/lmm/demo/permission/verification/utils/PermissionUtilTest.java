package show.lmm.demo.permission.verification.utils;

import org.junit.jupiter.api.Test;
import show.lmm.demo.permission.verification.core.model.PermissionEnum;
import show.lmm.demo.permission.verification.core.utils.PermissionUtils;

import static org.junit.jupiter.api.Assertions.*;

/**
 * 权限验证工具类测试
 *
 * @author 刘明明
 * @since 2022-02-17 10:00:23
 */
public class PermissionUtilTest {

    /**
     * 增加权限
     *
     * @since 刘明明/2022-02-17 10:00:50
     **/
    @Test
    public void addPermission() {
        int permission = 0;
        permission = PermissionUtils.addPermission(permission, PermissionEnum.VIEW);
        permission = PermissionUtils.addPermission(permission, PermissionEnum.ADD);
        permission = PermissionUtils.addPermission(permission, PermissionEnum.EDIT);
        permission = PermissionUtils.addPermission(permission, PermissionEnum.DELETE);
        assertEquals(60, permission);
    }

    /**
     * 验证是否有权限
     *
     * @since 刘明明/2022-02-17 10:01:06
     **/
    @Test
    public void hasPermission() {
        int permission = 4;
        assertTrue(PermissionUtils.hasPermission(permission, PermissionEnum.VIEW));
        assertFalse(PermissionUtils.hasPermission(permission, PermissionEnum.ADD));
    }

    /**
     * 测试删除权限
     *
     * @since 刘明明/2022-02-17 10:30:57
     **/
    @Test
    public void delPermission() {
        int permission = 0;
        //添加浏览权限
        permission = PermissionUtils.addPermission(permission, PermissionEnum.VIEW);
        //验证是否刘浏览权限
        assertTrue(PermissionUtils.hasPermission(permission, PermissionEnum.VIEW));
        //删除浏览权限
        permission = PermissionUtils.delPermission(permission, PermissionEnum.VIEW);
        //验证是否刘浏览权限
        assertFalse(PermissionUtils.hasPermission(permission, PermissionEnum.VIEW));
    }
}
