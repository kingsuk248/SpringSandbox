package org.example.lesson9;

import org.example.lesson8.CollaborativeFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;

@SpringBootApplication
@ComponentScan(basePackages="org.example.lesson10")
@ComponentScan(includeFilters = @ComponentScan.Filter (type= FilterType.REGEX, pattern = "org.example.lesson9.*"))
public class MovieRecommenderApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(MovieRecommenderApplication.class, args);
        ContentBasedFilter filter = context.getBean(ContentBasedFilter.class);
        System.out.println("\nMovie with prototype scope");
        System.out.println(filter.getMovie());
        System.out.println(filter.getMovie());
        System.out.println(filter.getMovie());

        System.out.println("\nContentBasedFilter instances created: " + filter.getInstances());
        System.out.println("\nMovie instances created: " + Movie.getInstances());

    }

}
