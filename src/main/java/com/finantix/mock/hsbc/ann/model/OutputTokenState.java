package com.finantix.mock.hsbc.ann.model;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * The Class OutputTokenState.
 */
@XmlRootElement
public class OutputTokenState {

    /** The token type. */
    private String token_type;

    /**
     * Gets the token type.
     *
     * @return the token type
     */
    public String getToken_type() {
        return token_type;
    }

    /**
     * Sets the token type.
     *
     * @param token_type
     *            the new token type
     */
    public void setToken_type(String token_type) {
        this.token_type = token_type;
    }
}
