package org.example.lesson12;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.inject.Inject;
import javax.inject.Named;

//@Component
@Named // Java EE Specs
public class RecommenderImplementation {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    private Filter filter;

    public RecommenderImplementation() {
        logger.info("Constructing RecommenderImplementation...");
    }

    //@Autowired
    @Inject // Java EE Specs
    public void setFilter(@Qualifier("CF")  Filter filter) {
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
