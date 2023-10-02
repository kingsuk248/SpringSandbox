package org.example.lesson16;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.Arrays;

@SpringBootApplication
public class MovieRecommenderApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(MovieRecommenderApplication.class, args);
        RecommenderImplementation recommender = context.getBean(RecommenderImplementation.class);
        String[] movies = recommender.recommendMovies("Finding Nemo");
        System.out.println(Arrays.toString(movies));

        Movie m1 = context.getBean(Movie.class);
        Movie m2 = context.getBean(Movie.class);

        System.out.println(m1);
        System.out.println(m2);
    }

}
