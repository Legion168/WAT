package com.org.watweb.bootstrap;

import com.ibm.watson.assistant.v2.Assistant;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {
    private final ApplicationContext context;

    public DataLoader(ApplicationContext context) {
        this.context = context;
    }

    @Override
    public void run(String... args) throws Exception {
        Assistant assistant = context.getBean(Assistant.class);

        System.out.println(assistant);
        System.out.println(assistant.getAuthenticator());
    }
}
