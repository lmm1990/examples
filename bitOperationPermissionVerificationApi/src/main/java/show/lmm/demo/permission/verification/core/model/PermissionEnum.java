package show.lmm.demo.permission.verification.core.model;

import lombok.Getter;

import java.util.Collection;
import java.util.HashSet;

/**
 * 权限类型
 *
 * @author 刘明明
 * @since 2022-02-17 10:03:12
 */
@Getter
public enum PermissionEnum {
    VIEW(2, "查看"),
    ADD(3, "添加"),
    EDIT(4, "编辑"),
    DELETE(5, "删除");

    /**
     * 权限id
     */
    private int id;

    /**
     * 权限名称
     */
    private String name;

    PermissionEnum(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public static final Collection<Integer> rightList = new HashSet<>() {{
        add(2);
        add(3);
        add(4);
        add(5);
        add(6);
        add(7);
        add(8);
    }};
}
