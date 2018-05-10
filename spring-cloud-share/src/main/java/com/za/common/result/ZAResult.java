package com.za.common.result;

import java.io.Serializable;

public class ZAResult<T> implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private String            code;
    private String            message;
    private T                 result;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }

    public ZAResult(String code, String message, T result) {
        super();
        this.code = code;
        this.message = message;
        this.result = result;
    }

    enum STATUS {
        SUCCESS("0", "成功"),
        FAIL("-1", "失败");
        String code;
        String message;

        private STATUS(String code, String message) {
            this.code = code;
            this.message = message;
        }

        public String getCode() {
            return code;
        }

        public String getMessage() {
            return message;
        }

    }

}
