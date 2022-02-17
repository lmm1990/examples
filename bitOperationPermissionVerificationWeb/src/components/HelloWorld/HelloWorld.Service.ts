import { defineComponent, ref } from "vue";
import type { Ref } from "vue";
import { addPermission, delPermission, getPagePermission } from '@/utils/permissionUtils'
import { RightType } from '@/utils/constants'
import type { PagePermission } from '@/types/PagePermission';

class HelloWorldService {

    /**
     * 当前权限值
     */
    currentPermissionValue = ref(0)

    /**
     * 页面权限
     */
    pagePermissions: Ref<PagePermission> = ref({
        view: false,
        add: false,
        edit: false,
        delete: false
    })

    constructor() {
        this.pagePermissions.value = getPagePermission(this.currentPermissionValue.value)
    }

    /**
     * 添加权限
     * @param typeId 类型id
     */
    onAddPermission(typeId: number) {
        switch (typeId) {
            case 1:
                this.currentPermissionValue.value = addPermission(this.currentPermissionValue.value, RightType.VIEW)
                break;
            case 2:
                this.currentPermissionValue.value = addPermission(this.currentPermissionValue.value, RightType.ADD)
                break;
            case 3:
                this.currentPermissionValue.value = addPermission(this.currentPermissionValue.value, RightType.EDIT)
                break;
            case 4:
                this.currentPermissionValue.value = addPermission(this.currentPermissionValue.value, RightType.DELETE)
                break;
        }
        this.pagePermissions.value = getPagePermission(this.currentPermissionValue.value)
    }

    /**
     * 删除权限
     * @param typeId 类型id
     */
    onDeletePermission(typeId: number) {
        switch (typeId) {
            case 1:
                this.currentPermissionValue.value = delPermission(this.currentPermissionValue.value, RightType.VIEW)
                break;
            case 2:
                this.currentPermissionValue.value = delPermission(this.currentPermissionValue.value, RightType.ADD)
                break;
            case 3:
                this.currentPermissionValue.value = delPermission(this.currentPermissionValue.value, RightType.EDIT)
                break;
            case 4:
                this.currentPermissionValue.value = delPermission(this.currentPermissionValue.value, RightType.DELETE)
                break;
        }
        this.pagePermissions.value = getPagePermission(this.currentPermissionValue.value)
    }
}

export default defineComponent({
    name: "HelloWorld",
    setup: () => {
        const helloWorldService = new HelloWorldService();
        return {
            currentPermissionValue: helloWorldService.currentPermissionValue,
            pagePermissions: helloWorldService.pagePermissions,
            onAddPermission: helloWorldService.onAddPermission.bind(helloWorldService),
            onDeletePermission: helloWorldService.onDeletePermission.bind(helloWorldService),
        }
    },
});