package org.example.lesson13;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class MovieRecommenderApplication {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MovieRecommenderApplication.class);
        RecommenderImplementation recommender = context.getBean(RecommenderImplementation.class);
        context.close();
    }

}
