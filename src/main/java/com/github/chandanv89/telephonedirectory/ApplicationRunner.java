package com.github.chandanv89.telephonedirectory;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

/**
 * The type Application runner.
 */
@Configuration
@ImportResource({"classpath*:appContext.xml"})
@SpringBootApplication
public class ApplicationRunner {
    private static final Logger LOGGER = LogManager.getLogger();

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        LOGGER.info(">>> Initializing the application...");
        long t1 = System.currentTimeMillis();
        ApplicationContext context = SpringApplication.run(ApplicationRunner.class, args);
        LOGGER.info(">>> Started application in " + (System.currentTimeMillis() - t1) / 1000.0 + " seconds");
    }
}
