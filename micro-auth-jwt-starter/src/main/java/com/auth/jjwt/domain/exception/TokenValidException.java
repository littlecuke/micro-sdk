package com.auth.jjwt.domain.exception;

import com.micro.commons.exception.MicroException;

public class TokenValidException extends MicroException {

    private static final long serialVersionUID = -7739554046719142410L;

    public TokenValidException(Integer code, Object data, String message, Throwable cause) {
        super(code, data, message, cause);
    }

    public TokenValidException(Integer code, Object data, String message) {
        super(code, data, message);
    }

    public TokenValidException(Integer code, String message) {
        super(code, message);
    }

    public TokenValidException(String message, Throwable cause) {
        super(message, cause);
    }

    public TokenValidException() {
    }
}
