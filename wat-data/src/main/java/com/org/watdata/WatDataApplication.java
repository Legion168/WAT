package com.org.watdata;

import com.ibm.watson.assistant.v2.Assistant;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class WatDataApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(WatDataApplication.class, args);

		Assistant assistant = context.getBean(Assistant.class);

		System.out.println(assistant);
	}

}
