package com.finantix.mock.hsbc.ann.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class AlertVariableDTO {
    private String name;
    private String value;
    private String type;

    public AlertVariableDTO() {
    }

    public AlertVariableDTO(String name, String value, String type) {
        this.name = name;
        this.value = value;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "AlertVariableDTO [name=" + name + ", value=" + value + ", type=" + type + "]";
    }

}
