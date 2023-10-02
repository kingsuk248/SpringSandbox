package org.example.lesson11;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class RecommenderImplementation {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    private Filter filter;

    public RecommenderImplementation() {
        logger.info("Constructing RecommenderImplementation...");
    }

    @Autowired
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

    @PreDestroy
    public void doCleanupActivities() {
        logger.info("RecommenderImplementation preDestroy...");
    }

}
