package cn.itclass.auth.exception;

/**
 * 校验失败异常类
 */
public class AuthFilterException extends RuntimeException {

    static final long serialVersionUID = -7034852190745773939L;

    public AuthFilterException(String message, Throwable cause) {
        super(message, cause);
    }

    public AuthFilterException(String message) {
        super(message);
    }
}
