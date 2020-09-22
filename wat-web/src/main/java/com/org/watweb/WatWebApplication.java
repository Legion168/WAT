package com.org.watweb;

import com.ibm.cloud.sdk.core.security.BasicAuthenticator;
import com.ibm.watson.assistant.v2.Assistant;
import com.org.watdata.model.Credentials;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class WatWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(WatWebApplication.class, args);
	}

}
