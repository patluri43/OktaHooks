package com.okta.hooks.Inline.PasswordImportHook.service;

import com.okta.hooks.Inline.PasswordImportHook.PasswordImport;
import com.okta.hooks.Inline.PasswordImportHook.RequestModal.RequestCredential;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class LegacyAuthenticator {

    private static final Logger logger = LoggerFactory.getLogger(LegacyAuthenticator.class);


    public boolean legacyAuth(RequestCredential credentials) {

        boolean isAuthnSuccess = false;


        logger.info(credentials.getUsername());
        logger.info(credentials.getPassword());


        /*
         **************************************
         **************************************
         **************************************
         *********Implement your logic*********
         **************************************
         **************************************
         **************************************
         */

        /* pass the passwordImportRequest.getData().getContext().getCredential() to your legacy Authentication Service */


        /* If Authn is success, then return value must be true*/

        return isAuthnSuccess;

    }
}
