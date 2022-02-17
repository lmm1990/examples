/**
 * 页面权限
 */
export interface PagePermission {

    /**
     * 是否有浏览权限
     */
    view: boolean;

    /**
     * 是否有添加权限
     */
    add: boolean;

    /**
     * 是否有编辑权限
     */
    edit: boolean;

    /**
     * 是否有删除权限
     */
    delete: boolean;
}