package com.finantix.mock.hsbc.ann.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * The Class InputTokenState.
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class InputTokenState {

    /** The token type. */
    private String token_type;

    /** The username. */
    private String username;

    /** The password. */
    private String password;

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

    /**
     * Gets the username.
     *
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * Sets the username.
     *
     * @param username
     *            the new username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Gets the password.
     *
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets the password.
     *
     * @param password
     *            the new password
     */
    public void setPassword(String password) {
        this.password = password;
    }
}
