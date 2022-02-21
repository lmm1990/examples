package show.lmm.validation.core.view.request;

import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.Collection;
import java.util.List;

/**
 * 获得首页信息reuqest
 *
 * @author 刘明明
 * @since 2022-02-18 11:13
 */
@Data
public class GetIndexInfoRequest {

    @NotNull(message = "notBlank参数不能为null")
    @NotBlank(message = "notBlank参数不能为空")
    private String notBlank;

    @NotNull(message = "notNull参数不能为null")
    private String notNull;

    @Max(value = 10, message = "max参数不能大于10")
    private int max;

    @Min(value = 1, message = "min参数不能小于1")
    private int min;

    @Pattern(regexp = "^\\d{4}\\-\\d{2}\\-\\d{2}$", message = "date格式错误")
    private String date;

    @Valid
    @NotEmpty(message = "children参数不能为空")
    @NotNull(message = "children参数不能为null")
    private List<Child> children;

    @Data
    public static class Child {

        @NotNull(message = "Child.notNull参数不能为null")
        private String notNull;
    }
}
