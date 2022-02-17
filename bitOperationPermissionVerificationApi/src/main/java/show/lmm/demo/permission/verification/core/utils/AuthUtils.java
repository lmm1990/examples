package show.lmm.demo.permission.verification.core.utils;

import show.lmm.demo.permission.verification.core.DataHandler;
import show.lmm.demo.permission.verification.core.model.PermissionEnum;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 权限工具类
 *
 * @author 刘明明
 * @since 2022-02-17 10:39:18
 */
public class AuthUtils {

    /**
     * 查询页面权限
     *
     * @param pageId: 页面id
     * @return int
     * @since 刘明明/2022-02-17 11:19:37
     **/
    public static int getPagePermissionValue(int pageId) {
        long userId = DataHandler.getAuthUserId();
        AtomicInteger permissionValue = new AtomicInteger();
        DataHandler.userRoleList.getOrDefault(userId, new ArrayList<>()).forEach((roleId) -> {
            int rightItem = DataHandler.rolePageRightMap.getOrDefault(String.format("%d_%d", roleId, pageId), 0);
            if (rightItem < 1) {
                return;//continue
            }
            if (PermissionUtils.hasPermission(rightItem, PermissionEnum.VIEW) && !PermissionUtils.hasPermission(permissionValue.get(), PermissionEnum.VIEW)) {
                permissionValue.set(PermissionUtils.addPermission(permissionValue.get(), PermissionEnum.VIEW));
            }
            if (PermissionUtils.hasPermission(rightItem, PermissionEnum.ADD) && !PermissionUtils.hasPermission(permissionValue.get(), PermissionEnum.ADD)) {
                permissionValue.set(PermissionUtils.addPermission(permissionValue.get(), PermissionEnum.ADD));
            }
            if (PermissionUtils.hasPermission(rightItem, PermissionEnum.EDIT) && !PermissionUtils.hasPermission(permissionValue.get(), PermissionEnum.EDIT)) {
                permissionValue.set(PermissionUtils.addPermission(permissionValue.get(), PermissionEnum.EDIT));
            }
            if (PermissionUtils.hasPermission(rightItem, PermissionEnum.DELETE) && !PermissionUtils.hasPermission(permissionValue.get(), PermissionEnum.DELETE)) {
                permissionValue.set(PermissionUtils.addPermission(permissionValue.get(), PermissionEnum.DELETE));
            }
        });
        return permissionValue.get();
    }
}
