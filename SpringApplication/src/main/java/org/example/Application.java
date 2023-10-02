package org.example;

import org.example.lesson2.ContentBasedFilter;
import org.example.lesson2.RecommenderImplementation;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
        RecommenderImplementation recommender = new RecommenderImplementation(new ContentBasedFilter());
        String[] result = recommender.recommendMovies("Finding Nemo");
        System.out.println(Arrays.toString(result));
    }

}
