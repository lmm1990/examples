import { addPermission, hasPermission, delPermission } from '../utils/permissionUtils'
import { RightType } from '../../src/utils/constants'
import { describe, it, expect } from "vitest";

/**
 * 验证权限
 */
describe('hasPermission', () => {
    it("renders properly", () => {
        let permission = 0;

        permission = addPermission(permission, RightType.VIEW);
        permission = addPermission(permission, RightType.ADD);

        //检查查看权限
        expect(hasPermission(permission, RightType.VIEW)).toBeTruthy()
        //检查添加权限
        expect(hasPermission(permission, RightType.ADD)).toBeTruthy()
        //检查修改权限
        expect(hasPermission(permission, RightType.EDIT)).toBeFalsy()
        //检查删除权限
        expect(hasPermission(permission, RightType.DELETE)).toBeFalsy()

        //删除添加权限
        permission = delPermission(permission, RightType.ADD);
        //检查添加权限
        expect(hasPermission(permission, RightType.ADD)).toBeFalsy()
    });
})