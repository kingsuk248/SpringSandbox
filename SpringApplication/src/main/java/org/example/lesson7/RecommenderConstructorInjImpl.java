package org.example.lesson7;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class RecommenderConstructorInjImpl {

    private final Filter filter;

    @Autowired // Optional for constructor injection
    public RecommenderConstructorInjImpl(@Qualifier("collaborativeFilter") Filter filter) {
        this.filter = filter;
        System.out.println("Inside Constructor...");
    }

    public String[] recommendMovies(String movie) {
        System.out.println("Name of filter: " + this.filter);
        return filter.getRecommendations(movie);
    }

}
