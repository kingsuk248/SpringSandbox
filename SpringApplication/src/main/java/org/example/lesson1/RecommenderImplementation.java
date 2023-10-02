package org.example.lesson1;

public class RecommenderImplementation {
    public String[] recommendMovies(String movie) {
        ContentBasedFilter filter = new ContentBasedFilter();
        String[] results = filter.getRecommendations(movie);
        return results;
    }
}
