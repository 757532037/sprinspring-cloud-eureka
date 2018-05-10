package com.za.common.result;

public class HLResult<T> extends ZAResult<T> {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    public HLResult(String code, String message, T result) {
        super(code, message, result);
    }

    public static <T> HLResult<T> fail(String code, String message, T result) {
        return new HLResult<T>(code, message, result);
    }

    private static Boolean success = false;

    public static <T> HLResult<T> success(T result) {
        success = true;
        return new HLResult<T>(STATUS.SUCCESS.getCode(), STATUS.SUCCESS.getMessage(), result);
    }

    public static Boolean isSuccess() {
        return Boolean.TRUE == success;
    }

}
