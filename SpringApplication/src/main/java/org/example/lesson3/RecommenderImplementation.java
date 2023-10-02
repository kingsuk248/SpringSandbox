package org.example.lesson3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RecommenderImplementation {

    @Autowired
    private Filter contentBasedFilter;

    public String[] recommendMovies(String movie) {
        System.out.println("Name of filter: " + this.contentBasedFilter);
        return contentBasedFilter.getRecommendations(movie);
    }

}
