package com.xr.common.exception.user;

/**
 * 用户密码不正确或不符合规范异常类
 *
 * @author xr
 */
public class UserPasswordNotMatchException extends UserException {
    private static final long serialVersionUID = 1L;

    public UserPasswordNotMatchException() {
        super("user.password.not.match" , null);
    }
}
