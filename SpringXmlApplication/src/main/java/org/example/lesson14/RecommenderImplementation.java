package org.example.lesson14;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class RecommenderImplementation {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    private Filter filter;

    public RecommenderImplementation(Filter filter) {
        logger.info("Constructing RecommenderImplementation...");
        this.filter = filter;
    }

    public void setFilter(Filter filter) {
        logger.info("Inside RecommenderImplementation setter method...");
        this.filter = filter;
    }

    @PostConstruct
    public void doTaskAfterConstruction() {
        logger.info("RecommenderImplementation postConstruct...");
    }

    public String[] recommendMovies(String movie) {
        System.out.println("Name of filter: " + this.filter);
        return filter.getRecommendations(movie);
    }

    public Movie findClosestMatch(String movie) {
        //TODO
        return null;
    }

    @PreDestroy
    public void doCleanupActivities() {
        logger.info("RecommenderImplementation preDestroy...");
    }

}
