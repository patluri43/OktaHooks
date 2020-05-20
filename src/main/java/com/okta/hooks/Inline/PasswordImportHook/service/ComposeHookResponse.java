package com.okta.hooks.Inline.PasswordImportHook.service;

import com.okta.hooks.Inline.PasswordImportHook.ResponseModal.ResponseCommand;
import com.okta.hooks.Inline.PasswordImportHook.ResponseModal.ResponseCommands;
import com.okta.hooks.Inline.PasswordImportHook.ResponseModal.ResponseValue;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ComposeHookResponse {

    public ResponseCommands computeResponse(boolean verified) {

        ArrayList responseList = new ArrayList();

        ResponseValue value = new ResponseValue();

        ResponseCommand command = new ResponseCommand();

        if(!verified) {
            value.setCredential("UNVERIFIED");
        } else {
            value.setCredential("VERIFIED");
        }

        command.setType("com.okta.action.update");

        command.setValue(value);

        responseList.add(command);

        ResponseCommands response = new ResponseCommands();

        response.setCommands(responseList);

        return response;
    }
}
