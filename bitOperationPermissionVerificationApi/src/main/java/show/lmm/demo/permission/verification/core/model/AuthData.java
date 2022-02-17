package show.lmm.demo.permission.verification.core.model;

import lombok.Data;

/**
 * 身份验证数据
 * @author 刘明明
 * @since 2022-02-17 10:42:59
 */
@Data
public class AuthData {

    /**
     * 用户id
     */
    private long userId;

    private AuthData(Builder builder){
        this.userId=builder.userId;
    }

    public long getUserId() {
        return userId;
    }

    public static class Builder{

        /**
         * 用户id
         */
        private long userId;

        public Builder(long userId){
            this.userId=userId;
        }

        public Builder setUserId(int userId) {
            this.userId = userId;
            return this;
        }

        public AuthData build(){
            return new AuthData(this);
        }
    }
}
