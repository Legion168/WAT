package com.org.watweb.config;

import com.org.watweb.model.CredentialLogin;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CredentialLoginConfiguration {
    @Value("${watson.username}")
    private String username;

    @Value("${watson.token}")
    private String password;

    @Value("${watson.workspace-id}")
    private String workspaceId;

    @Value("${watson.endpoint}")
    private String endpoint;

    @Value("${watson.assistant-id}")
    private String assistantId;

    @Bean
    public CredentialLogin getCredential() {
        return CredentialLogin.builder().apikey(password).assistantId(assistantId)
                .endpoint(endpoint).username(username).workspaceId(workspaceId).build();
    }
}
