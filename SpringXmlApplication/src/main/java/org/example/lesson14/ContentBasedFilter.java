package org.example.lesson14;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PreDestroy;

public class ContentBasedFilter implements Filter {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    private static int instances = 0;
    //private final Movie movie;

    public ContentBasedFilter() {
        instances++;
        logger.info("ContentBasedFilter constructor invoked...");
        //this.movie = movie;
    }

    public void doSomeTaskAfterConstruction() {
        logger.info("ContentBasedFilter postConstruct...");
    }

    public int getInstances() {
        return instances;
    }

    /*public Movie getMovie() {
        return this.movie;
    }*/

    @Override
    public String[] getRecommendations(String movie) {
        return new String[]{"Finding Dory", "Ice Age"};
    }

    @PreDestroy
    public void doCleanupActivities() {
        logger.info("ContentBasedFilter preDestroy...");
    }
}
