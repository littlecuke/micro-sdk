package com.micro.commons.exception;

import com.micro.commons.constant.ErrorConstant;

public class MicroException extends RuntimeException{
    private static final long serialVersionUID = -911414626936059322L;

    // 异常码
    private Integer code = ErrorConstant.ERR_CODE;
    // 具体出错的数据或者其他相关数据
    private Object data;

    private String message;

    private Throwable cause;

    /***************************** exception info *****************************/

    private String className;
    private String fileName;
    private String methodName;
    private Integer lineNumber;


    public MicroException(Integer code, Object data, String message, Throwable cause) {
        this.code = code;
        this.data = data;
        this.message = message;
        this.cause = cause;
        StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
        int realStackNum = 0;
        for (StackTraceElement stackTraceElement : stackTraceElements) {
            if (!"getStackTrace".equals(stackTraceElement.getMethodName()) &&
                    !"<init>".equals(stackTraceElement.getMethodName())) {
                break;
            }
            realStackNum++;
        }
        fileName = stackTraceElements[realStackNum].getFileName();
        methodName = stackTraceElements[realStackNum].getMethodName();
        className = stackTraceElements[realStackNum].getClassName();
        lineNumber = stackTraceElements[realStackNum].getLineNumber();
    }

    /**
    * 格式化输出
    **/
    public String printf(){
        String out = "%s %s.%s(%s:%s)";
        return String.format(out,this.getClass().getSimpleName(),className,methodName,fileName,lineNumber);
    }

    public MicroException(Integer code, Object data, String message) {
        this(code,data,message,null);
    }

    public MicroException(Integer code, String message) {
        this(code,null,message,null);
    }

    public MicroException(String message, Throwable cause) {
        this(null,null,message,cause);
    }

    public MicroException() {
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public Throwable getCause() {
        return cause;
    }

    public void setCause(Throwable cause) {
        this.cause = cause;
    }
}
