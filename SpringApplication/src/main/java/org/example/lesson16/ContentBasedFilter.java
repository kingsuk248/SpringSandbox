package org.example.lesson16;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Service
public class ContentBasedFilter implements Filter {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    private static int instances = 0;
    private final Movie movie;

    @Autowired
    public ContentBasedFilter(Movie movie) {
        instances++;
        logger.info("ContentBasedFilter constructor invoked...");
        this.movie = movie;
    }

    @PostConstruct
    public void doSomeTaskAfterConstruction() {
        logger.info("ContentBasedFilter postConstruct...");
    }

    public int getInstances() {
        return instances;
    }

    public Movie getMovie() {
        return this.movie;
    }

    public String[] getRecommendations(String movie) {
        return new String[]{"Finding Dory", "Ice Age"};
    }

    @PreDestroy
    public void doCleanupActivities() {
        logger.info("ContentBasedFilter preDestroy...");
    }
}
