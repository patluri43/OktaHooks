package com.okta.hooks.Inline.PasswordImportHook.ResponseModal;


import org.springframework.stereotype.Component;

@Component
public class ResponseValue {


    private String credential;

    public void setCredential(String credential) {
        this.credential = credential;
    }

    public String getCredential() {
        return credential;
    }
}
