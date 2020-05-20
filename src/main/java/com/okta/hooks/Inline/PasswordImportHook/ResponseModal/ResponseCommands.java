package com.okta.hooks.Inline.PasswordImportHook.ResponseModal;

import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class ResponseCommands {

    private ArrayList commands;


    public ArrayList getCommands() {
        return commands;
    }

    public void setCommands(ArrayList commands) {
        this.commands = commands;
    }
}
