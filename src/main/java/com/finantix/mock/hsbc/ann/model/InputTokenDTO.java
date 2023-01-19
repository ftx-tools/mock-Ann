package com.finantix.mock.hsbc.ann.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * The Class InputTokenDTO.
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class InputTokenDTO {

    /** The input token state. */
    private InputTokenState input_token_state;

    /** The output token state. */
    private OutputTokenState output_token_state;

    /**
     * Gets the input token state.
     *
     * @return the input token state
     */
    public InputTokenState getInput_token_state() {
        return input_token_state;
    }

    /**
     * Sets the input token state.
     *
     * @param input_token_state
     *            the new input token state
     */
    public void setInput_token_state(InputTokenState input_token_state) {
        this.input_token_state = input_token_state;
    }

    /**
     * Gets the output token state.
     *
     * @return the output token state
     */
    public OutputTokenState getOutput_token_state() {
        return output_token_state;
    }

    /**
     * Sets the output token state.
     *
     * @param output_token_state
     *            the new output token state
     */
    public void setOutput_token_state(OutputTokenState output_token_state) {
        this.output_token_state = output_token_state;
    }

}
