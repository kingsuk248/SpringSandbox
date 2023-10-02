package org.example.lesson9;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ContentBasedFilter implements Filter {
    private static int instances = 0;
    private final Movie movie;

    @Autowired
    public ContentBasedFilter(Movie movie) {
        instances++;
        System.out.println("ContentBasedFilter constructor invoked");
        this.movie = movie;
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
}
