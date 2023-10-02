package org.example;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class RecommendationController {

    @RequestMapping(method= RequestMethod.GET, value="/movies")
    // @GetMapping("/movies")
    public List<Movie> getAllMovies() {
        return List.of(new Movie(1, "Ice Age", 4.8),
                new Movie(2, "Finding Nemo", 4.2),
                new Movie(3, "Toy Story", 3.8),
                new Movie(4, "Shrek", 4.6));
    }
}
