package com.org.watweb.services;

import com.ibm.cloud.sdk.core.security.IamAuthenticator;
import com.ibm.watson.assistant.v2.Assistant;
import com.ibm.watson.assistant.v2.model.CreateSessionOptions;
import com.ibm.watson.assistant.v2.model.SessionResponse;
import com.org.watdata.model.Credentials;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class CredentialServiceImpl implements CredentialService {
    @Value("${watson.username}")
    private String username;

    @Value("${watson.password}")
    private String password;

    @Value("${watson.version}")
    private String version;

    @Value("${watson.workspace-id}")
    private String workspaceId;

    @Value("${watson.endpoint}")
    private String endpoint;

    @Value("${watson.assistant-id}")
    private String assistantId;

    @Override
    public Credentials getCredential() {
        Credentials credentials = new Credentials();
        credentials.setUsername(username);
        credentials.setPassword(password);
        credentials.setWorkspaceId(workspaceId);
        credentials.setVersion(version);
        credentials.setAssistantId(assistantId);
        credentials.setEndpoint(endpoint);

        return credentials;
    }

    @Override
    public boolean verifyCredential(Credentials credentials) {
//        BasicAuthenticator authenticator = new BasicAuthenticator(credentials.getUsername(), credentials.getPassword());

        IamAuthenticator authenticator = new IamAuthenticator(credentials.getPassword());

        Assistant assistant = new Assistant(version, authenticator);
        assistant.setServiceUrl(endpoint);

        CreateSessionOptions options = new CreateSessionOptions.Builder(assistantId).build();

        SessionResponse response = null;

        try {

            response = assistant.createSession(options).execute().getResult();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return response != null;
    }
}
