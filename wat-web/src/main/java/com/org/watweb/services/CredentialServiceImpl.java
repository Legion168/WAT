package com.org.watweb.services;

import com.ibm.cloud.sdk.core.security.IamAuthenticator;
import com.ibm.watson.assistant.v2.Assistant;
import com.ibm.watson.assistant.v2.model.CreateSessionOptions;
import com.ibm.watson.assistant.v2.model.SessionResponse;
import com.org.watweb.model.CredentialLogin;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

@Service
public class CredentialServiceImpl implements CredentialService {
    private final ApplicationContext applicationContext;

    public CredentialServiceImpl(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    @Override
    public CredentialLogin getCredential() {
        return applicationContext.getBean(CredentialLogin.class);
    }

    @Override
    public boolean verifyCredential(CredentialLogin credentials) {
        System.out.println("--------------------------------");
        System.out.println(credentials.toString());
        System.out.println("--------------------------------");

        IamAuthenticator authenticator = new IamAuthenticator(credentials.getApikey());

        Assistant assistant = new Assistant("2020-04-01", authenticator);
        assistant.setServiceUrl(credentials.getEndpoint());

        CreateSessionOptions options = new CreateSessionOptions.Builder(credentials.getAssistantId()).build();

        SessionResponse response = null;

        try {
            response = assistant.createSession(options).execute().getResult();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return response != null;
    }
}
