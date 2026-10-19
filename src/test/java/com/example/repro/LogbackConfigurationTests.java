package com.example.repro;

import ch.qos.logback.classic.Logger;
import ch.qos.logback.classic.LoggerContext;
import org.junit.jupiter.api.Test;
import org.slf4j.LoggerFactory;

import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class LogbackConfigurationTests {

    @Test
    void logbackSpringXmlIsApplied() {
        LoggerContext context = (LoggerContext) LoggerFactory.getILoggerFactory();
        Logger root = context.getLogger(Logger.ROOT_LOGGER_NAME);
        // Appender "REPRO" comes from logback-spring.xml, Spring Boot's defaults use "CONSOLE"
        assertThat(root.getAppender("REPRO")).isNotNull();
        assertThat(root.getAppender("CONSOLE")).isNull();
    }

}
