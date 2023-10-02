package org.example.lesson7;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class RecommenderSetterInjImpl {

    private Filter filter;

    @Autowired
    private void setFilter(@Qualifier("contentBasedFilter") Filter filter) {
        System.out.println("Inside Setter...");
        this.filter = filter;
    }

    public String[] recommendMovies(String movie) {
        System.out.println("Name of filter: " + this.filter);
        return filter.getRecommendations(movie);
    }

}
