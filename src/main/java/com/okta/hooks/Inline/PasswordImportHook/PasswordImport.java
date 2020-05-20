package com.okta.hooks.Inline.PasswordImportHook;

import com.okta.hooks.Inline.PasswordImportHook.RequestModal.PasswordImportRequestModal;
import com.okta.hooks.Inline.PasswordImportHook.ResponseModal.ResponseCommand;
import com.okta.hooks.Inline.PasswordImportHook.ResponseModal.ResponseCommands;
import com.okta.hooks.Inline.PasswordImportHook.ResponseModal.ResponseValue;
import com.okta.hooks.Inline.PasswordImportHook.service.ComposeHookResponse;
import com.okta.hooks.Inline.PasswordImportHook.service.LegacyAuthenticator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;


@RestController
public class PasswordImport {


    @Autowired
    private LegacyAuthenticator legacyAuth;

    @Autowired
    private ComposeHookResponse computeHookResponse;

    private static final Logger logger = LoggerFactory.getLogger(PasswordImport.class);


    @RequestMapping("/hello")
    public String index() {
        return "Greetings from Spring Boot!";
    }

    @PostMapping(path = "/passwordVerification", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseCommands> passwordVerification(@RequestBody PasswordImportRequestModal passwordImportRequest) {


        boolean hookverified = false;

        HttpHeaders httpHeaders = new HttpHeaders();

        hookverified = legacyAuth.legacyAuth(passwordImportRequest.getData().getContext().getCredential());

        return new ResponseEntity<ResponseCommands>(computeHookResponse.computeResponse(hookverified), httpHeaders, HttpStatus.CREATED);
    }

}
