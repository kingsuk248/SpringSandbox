package org.example;

import org.example.dao.PlayerSpringDataRepository;
import org.example.pojo.Player;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Date;

@SpringBootApplication
public class SpringDataJPAApplication implements CommandLineRunner {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    public static void main(String[] args) {
        SpringApplication.run(SpringDataJPAApplication.class);
    }

    @Autowired
    private PlayerSpringDataRepository repo;

    @Override
    public void run(String... args) throws Exception {
        logger.info("Inserting Player: {}", repo.save(new Player("Djokovic", "Serbia",
                Date.valueOf("1987-05-22"), 81)));
        logger.info("Inserting Player: {}", repo.save(new Player("Monfils", "France",
                Date.valueOf("1986-09-01"), 10)));
        logger.info("Inserting Player: {}", repo.save(new Player("Thiem", "Austria",
                new Date(System.currentTimeMillis()), 17)));

        logger.info("Updating Player with Id 3: {}", repo.save(new Player(3, "Thiem", "Austria",
                Date.valueOf("1993-09-03"), 17)));

        logger.info("Player with Id 2: {}", repo.findById(1));

        //repo.deleteById(3);

        logger.info("All Players: {}", repo.findAll());
    }
}
