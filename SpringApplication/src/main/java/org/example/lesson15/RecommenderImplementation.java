package org.example.lesson15;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Service
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


    @Value("${recommender.bla.bla.bla.favoriteMovie: Finding something...}")
    private String favoriteMovie;
    public String getFavoriteMovie() {
        return favoriteMovie;
    }

}
