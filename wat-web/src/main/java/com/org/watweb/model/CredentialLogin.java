package com.org.watweb.model;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CredentialLogin {
    private String username;
    private String apikey;
    private String endpoint;
    private String workspaceId;
    private String assistantId;

    @Override
    public String toString() {
        return "CredentialLogin{" +
                "username='" + username + '\'' +
                ", apikey='" + apikey + '\'' +
                ", endpoint='" + endpoint + '\'' +
                ", workspaceId='" + workspaceId + '\'' +
                ", assistantId='" + assistantId + '\'' +
                '}';
    }
}
