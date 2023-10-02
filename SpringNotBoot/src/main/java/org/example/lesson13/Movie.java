package org.example.lesson13;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.inject.Named;

//@Component
@Named // Java EE Specs
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE, proxyMode= ScopedProxyMode.TARGET_CLASS)
public class Movie {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private static int instances = 0;

    private int id;
    private String name;
    private String genre;
    private String producer;

    public Movie() {
        instances++;
        System.out.println("Movie constructor invoked");
    }

    @PostConstruct
    public void doTaskAfterConstruction() {
        logger.info("Movie postConstruct...");
    }

    public static int getInstances() {
        return instances;
    }

    @PreDestroy
    public void cleanUp() {
        logger.info("Movie preDestroy");
    }
}
