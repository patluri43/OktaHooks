package com.okta.hooks.Inline;

import model.PasswordImportHook.RequestModel.PasswordImportRequestModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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


    private static final Logger logger = LoggerFactory.getLogger(PasswordImport.class);


    @RequestMapping("/hello")
    public String index() {
        return "Greetings from Spring Boot!";
    }

    @PostMapping(path = "/passwordVerification", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseCommands> passwordVerification(@RequestBody PasswordImportRequestModel passwordImportRequest) {


        System.out.println(passwordImportRequest.getEventId());


        logger.info(passwordImportRequest.getData().getContext().getCredential().getUsername());
        logger.info(passwordImportRequest.getData().getContext().getCredential().getPassword());


        /* pass the passwordImportRequest.getData().getContext().getCredential() to your legacy Authentication Service */
        HttpHeaders httpHeaders = new HttpHeaders();
//        logger.info("print type::"+command.getType());

        return new ResponseEntity<ResponseCommands>(computeResponse(true), httpHeaders, HttpStatus.CREATED);
    }


    private ResponseCommands computeResponse(boolean verified) {


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

    public static class ResponseSingleCommand {

        private String type;

        private ResponseValue value;


        public void setType(String type) {
            this.type = type;
        }

        public String getType() {
            return type;
        }

        public ResponseValue getValue() {
            return value;
        }


    }
}
