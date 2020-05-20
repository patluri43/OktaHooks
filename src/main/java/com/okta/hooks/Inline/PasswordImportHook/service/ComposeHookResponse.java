package com.okta.hooks.Inline.PasswordImportHook.service;

import com.okta.hooks.Inline.PasswordImportHook.ResponseModal.ResponseCommand;
import com.okta.hooks.Inline.PasswordImportHook.ResponseModal.ResponseCommands;
import com.okta.hooks.Inline.PasswordImportHook.ResponseModal.ResponseValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ComposeHookResponse {


    @Autowired
    private ResponseValue value;

    @Autowired
    private ResponseCommand command;

    @Autowired
    private ResponseCommands response;


    public ResponseCommands computeResponse(boolean verified) {

        ArrayList responseList = new ArrayList();

        if(!verified) {
            value.setCredential("UNVERIFIED");
        } else {
            value.setCredential("VERIFIED");
        }

        command.setType("com.okta.action.update");

        command.setValue(value);

        responseList.add(command);

        response.setCommands(responseList);

        return response;
    }
}
