package com.org.watweb.services;

import com.org.watweb.model.CredentialLogin;

public interface CredentialService {
    boolean verifyCredential(CredentialLogin credentials);
    CredentialLogin getCredential();
}
