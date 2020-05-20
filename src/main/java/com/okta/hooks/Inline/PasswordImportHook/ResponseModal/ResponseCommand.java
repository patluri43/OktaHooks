package com.okta.hooks.Inline.PasswordImportHook.ResponseModal;

public class ResponseCommand {

    private String type;

    private ResponseValue value;


    public ResponseValue getValue() {
        return value;
    }

    public void setValue(ResponseValue value) {
        this.value = value;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
