package com.finantix.mock.hsbc.ann.model;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * The Class ErrorJWTDTO for Authentication.
 */
@XmlRootElement
public class ErrorJWTDTO {

    /** The code. */
    private int code;

    /** The reason. */
    private String reason;

    /** The message. */
    private String message;

    /**
     * Instantiates a new error JWTDTO.
     *
     * @param code
     *            the code
     * @param reason
     *            the reason
     * @param message
     *            the message
     */
    public ErrorJWTDTO(int code, String reason, String message) {
        this.code = code;
        this.reason = reason;
        this.message = message;
    }

    /**
     * Gets the code.
     *
     * @return the code
     */
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
     * Gets the reason.
     *
     * @return the reason
     */
    public String getReason() {
        return reason;
    }

    /**
     * Sets the reason.
     *
     * @param reason
     *            the new reason
     */
    public void setReason(String reason) {
        this.reason = reason;
    }

    /**
     * Gets the message.
     *
     * @return the message
     */
    public String getMessage() {
        return message;
    }

    /**
     * Sets the message.
     *
     * @param message
     *            the new message
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * To string.
     *
     * @return the string
     */
    @Override
    public String toString() {
        return "ErrorJWTDTO [code=" + code + ", reason=" + reason + ", message=" + message + "]";
    }

}
