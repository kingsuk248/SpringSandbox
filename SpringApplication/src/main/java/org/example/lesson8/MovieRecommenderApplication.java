package org.example.lesson8;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.Arrays;

@SpringBootApplication
public class MovieRecommenderApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(MovieRecommenderApplication.class, args);
        System.out.println(context.getBean(ContentBasedFilter.class));
        System.out.println(context.getBean(ContentBasedFilter.class));

        System.out.println(context.getBean(CollaborativeFilter.class));
        System.out.println(context.getBean(CollaborativeFilter.class));
    }

}
