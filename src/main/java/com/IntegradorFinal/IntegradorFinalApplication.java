package com.IntegradorFinal;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import static io.swagger.v3.oas.integration.StringOpenApiConfigurationLoader.LOGGER;

@SpringBootApplication
public class IntegradorFinalApplication {

	public static void main(String[] args) {

		SpringApplication.run(IntegradorFinalApplication.class, args);
		LOGGER.info("Proyecto Integrador is now running....");
	}

}
