package show.lmm.validation.core.view.request;

import lombok.Data;
import show.lmm.validation.core.annotation.validator.validation.StartsWith;

/**
 * 自定义验证request
 *
 * @author 刘明明
 * @since 2022-02-18 14:00
 */
@Data
public class CustomValidatedRequest {

    @StartsWith(prefix = "ID", message = "卡号必须以id开头")
    private int cardNumber;
}
