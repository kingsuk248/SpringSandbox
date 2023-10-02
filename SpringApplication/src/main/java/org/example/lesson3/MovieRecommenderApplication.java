package org.example.lesson3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.Arrays;

@SpringBootApplication
public class MovieRecommenderApplication {

    public static void main(String[] args) {
        /*
        SpringApplication.run(MovieRecommenderApplication.class, args);
        RecommenderImplementation recommender = new RecommenderImplementation(new ContentBasedFilter());
        String[] result = recommender.recommendMovies("Finding Nemo");
        System.out.println(Arrays.toString(result));
        */
        ApplicationContext context = SpringApplication.run(MovieRecommenderApplication.class, args);
        RecommenderImplementation recommender = context.getBean(RecommenderImplementation.class);
        String[] result = recommender.recommendMovies("Finding Nemo");
        System.out.println(Arrays.toString(result));
    }

}
