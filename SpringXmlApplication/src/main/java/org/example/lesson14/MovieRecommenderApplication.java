package org.example.lesson14;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;

public class MovieRecommenderApplication {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext  context = new ClassPathXmlApplicationContext("applicationContext.xml");
        System.out.println(Arrays.toString(context.getBeanDefinitionNames()));

        RecommenderImplementation recommender = context.getBean("recommenderImplementation2", RecommenderImplementation.class);
        System.out.println(Arrays.toString(recommender.recommendMovies("Finding Nemo")));
        context.close();
    }

}
