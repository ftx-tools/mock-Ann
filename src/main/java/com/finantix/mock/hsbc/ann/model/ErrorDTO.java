package com.finantix.mock.hsbc.ann.model;

/**
 * The Class ErrorDTO.
 */
public class ErrorDTO {
    private String error;

    public ErrorDTO(String error) {
        this.error = error;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    @Override
    public String toString() {
        return "ErrorDTO [error=" + error + "]";
    }

}
