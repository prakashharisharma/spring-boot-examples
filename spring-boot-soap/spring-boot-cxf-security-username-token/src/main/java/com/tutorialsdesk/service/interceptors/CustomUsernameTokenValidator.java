package com.tutorialsdesk.service.interceptors;

import org.apache.wss4j.common.ext.WSSecurityException;
import org.apache.wss4j.dom.handler.RequestData;
import org.apache.wss4j.dom.message.token.UsernameToken;
import org.apache.wss4j.dom.validate.Credential;
import org.apache.wss4j.dom.validate.UsernameTokenValidator;

public class CustomUsernameTokenValidator extends UsernameTokenValidator  {
	
	
	public Credential validate( Credential credential, RequestData request ) throws WSSecurityException {
        UsernameToken userToken = credential.getUsernametoken();
        
        final String userId = userToken.getName();
        
        System.out.println("USERNAME FROM TOKEN " + userId);
        
        final String password = userToken.getPassword();
        
        System.out.println("PASSWORD FROM TOKEN " + password);

        return credential;
    }

}