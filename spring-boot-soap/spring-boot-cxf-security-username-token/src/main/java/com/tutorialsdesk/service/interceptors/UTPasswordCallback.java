package com.tutorialsdesk.service.interceptors;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;

import org.apache.cxf.interceptor.InInterceptors;
import org.apache.wss4j.common.ext.WSPasswordCallback;

@InInterceptors
public class UTPasswordCallback implements CallbackHandler{

	private Map<String, String> passwords = new HashMap<>();
	
	public UTPasswordCallback() {
		passwords.put("cxf", "cxf");
	}
	
	@Override
	public void handle(Callback[] callbacks) throws IOException, UnsupportedCallbackException {
		for (Callback callback : callbacks) {
			WSPasswordCallback pc = (WSPasswordCallback) callback;
			
			System.out.println("*** USERNAME TOKEN **");
			
			System.out.println("*** USAGE TOKEN **" + pc.getUsage());
			
			System.out.println(pc.getIdentifier());
			
			// you won't be able to retrieve the password using callback.getPassword().
	        // to authenticate a user, you'll need to set the password tied to the user.
	        // user credentials are typically retrieved from DB or your own authentication source.
	        // if the password set here is the same as the password passed by caller, authentication is successful.
			
			
			String pass = passwords.get(pc.getIdentifier());
			

			
			if (pass != null) {
				pc.setPassword(pass);
				return;
			}
		}

	}

}
