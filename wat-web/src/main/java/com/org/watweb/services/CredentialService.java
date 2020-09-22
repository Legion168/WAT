package com.org.watweb.services;

import com.org.watdata.model.Credentials;

public interface CredentialService {
    boolean verifyCredential(Credentials credentials);
    Credentials getCredential();
}
