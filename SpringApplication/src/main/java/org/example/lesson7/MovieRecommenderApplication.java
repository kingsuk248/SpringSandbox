package org.example.lesson7;

import org.example.lesson6.RecommenderImplementation;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.Arrays;

@SpringBootApplication
public class MovieRecommenderApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(MovieRecommenderApplication.class, args);
        RecommenderConstructorInjImpl recommender = context.getBean(RecommenderConstructorInjImpl.class);
        String[] result = recommender.recommendMovies("Finding Nemo");
        System.out.println(Arrays.toString(result));


        RecommenderSetterInjImpl recommender2 = context.getBean(RecommenderSetterInjImpl.class);
        String[] result2 = recommender2.recommendMovies("Finding Nemo");
        System.out.println(Arrays.toString(result2));
    }

}
