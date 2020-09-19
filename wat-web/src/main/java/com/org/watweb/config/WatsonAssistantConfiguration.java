package com.org.watweb.config;

import com.ibm.cloud.sdk.core.security.BasicAuthenticator;
import com.ibm.watson.assistant.v2.Assistant;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource({"classpath:application.properties"})
public class WatsonAssistantConfiguration {
    @Value("watson.username")
    private String username;

    @Value("watson.password")
    private String password;

    @Value("watson.version")
    private String version;

    @Value("watson.workspace-id")
    private String workspace;

    @Value("watson.server")
    private String server;

    @Bean
    public Assistant getAssistant() {
        BasicAuthenticator basicAuthenticator = new BasicAuthenticator(username, password);
        Assistant assistant = new Assistant(version, basicAuthenticator);
        assistant.setServiceUrl(server);

        return assistant;
    }
}
