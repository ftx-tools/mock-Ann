package com.finantix.mock.hsbc.ann.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

// TODO: Auto-generated Javadoc
/**
 * The Class TokenDTO.
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class TokenDTO {

    /** The issued token. */
    private String issued_token;

    /**
     * Instantiates a new token DTO.
     *
     * @param tokenJWT
     *            the token JWT
     */
    public TokenDTO(String tokenJWT) {
        this.issued_token = tokenJWT;
    }

    /**
     * Gets the issued token.
     *
     * @return the issued token
     */
    public String getIssued_token() {
        return issued_token;
    }

    /**
     * Sets the issued token.
     *
     * @param issued_token
     *            the new issued token
     */
    public void setIssued_token(String issued_token) {
        this.issued_token = issued_token;
    }

}
