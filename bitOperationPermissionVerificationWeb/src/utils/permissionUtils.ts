import type { PagePermission } from '@/types/PagePermission';
import { RightType } from '@/utils/constants'

/**
 * 基础值
 */
const base = 1;// 该数字可以是一个范围

/**
 * 增加权限
 * @param permission 权限值
 * @param operate 权限
 */
export function addPermission(permission: number, operate: number) {
    const per = base << operate;
    permission |= per; // 增加权限时使用或，可以将权限对应的二进制位的1赋值给权限变量的0
    return permission;
}

/**
 * 删除权限
 * @param permission 权限值
 * @param operate 权限
 */
export function delPermission(permission: number, operate: number) {
    let per = base << operate;
    per = ~per; // 按位取反，取反之前的1，取反后变为0，再和权限数字进行与运算，1&0=0,1&1=1，0&1=0，这样删除对应权限，并且不影响原有权限
    return permission & per;
}

/**
 * 验证权限
 * @param permission 权限值
 * @param operate 权限
 */
export function hasPermission(permission: number, operate: number) {
    const per = base << operate;
    return (permission & per) === per; // 1&0=0;1&1=1;0&1=0; permission和per&操作之后，如果permission对应的位为1，则和per&的结果就等于per
}

// 判断是否有新增权限
export function hasAddPermission(permission: number) {
    const per = base << 3;
    return (permission & per) === per; // 1&0=0;1&1=1;0&1=0; permission和per&操作之后，如果permission对应的位为1，则和per&的结果就等于per
}

// 判断是否有编辑权限
export function hasEditPermission(permission: number) {
    const per = base << 4;
    return (permission & per) === per; // 1&0=0;1&1=1;0&1=0; permission和per&操作之后，如果permission对应的位为1，则和per&的结果就等于per
}

// 判断是否有删除权限
export function hasDeletePermission(permission: number) {
    const per = base << 5;
    return (permission & per) === per; // 1&0=0;1&1=1;0&1=0; permission和per&操作之后，如果permission对应的位为1，则和per&的结果就等于per
}

/**
 * 获取页面权限值
 * @param {number} permission 权限值
 */
export function getPagePermission(permission: number): PagePermission {
    return {
        view: hasPermission(permission, RightType.VIEW),
        add: hasPermission(permission, RightType.ADD),
        edit: hasPermission(permission, RightType.EDIT),
        delete: hasPermission(permission, RightType.DELETE)
    }
}