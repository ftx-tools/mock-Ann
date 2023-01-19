package com.finantix.mock.hsbc.ann.model;

/**
 * The Class ErrorDTO.
 */
public class ErrorMsgDTO {

    /** The code. */
    private int code;

    /** The msg. */
    private String msg;

    /**
     * Instantiates a new error msg DTO.
     *
     * @param msg
     *            the msg
     */
    public ErrorMsgDTO(int code, String msg) {
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    /**
     * Sets the code.
     *
     * @param code
     *            the new code
     */
    public void setCode(int code) {
        this.code = code;
    }

    /**
     * Gets the msg.
     *
     * @return the msg
     */
    public String getMsg() {
        return msg;
    }

    /**
     * Sets the msg.
     *
     * @param msg
     *            the new msg
     */
    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "ErrorMsgDTO [code=" + getCode() + ", msg=" + msg + "]";
    }

}
