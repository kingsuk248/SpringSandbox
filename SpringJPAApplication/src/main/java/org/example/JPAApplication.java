package org.example;

import org.example.dao.PlayerRepository;
import org.example.pojo.Player;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Date;

@SpringBootApplication
public class JPAApplication implements CommandLineRunner {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    public static void main(String[] args) {
        SpringApplication.run(JPAApplication.class, args);
    }

    @Autowired
    private PlayerRepository playerRepository;

    @Override
    public void run(String... args) throws Exception {
        logger.info("\n\n>> Inserting Player: {}\n", playerRepository.insertPlayer(
                new Player("Djokovic", "Serbia", Date.valueOf("1987-05-22"), 81)));

        logger.info("\n\n>> Inserting Player: {}\n", playerRepository.insertPlayer(
                new Player("Monfils", "France", Date.valueOf("1986-09-01"), 10)));

        logger.info("\n\n>> Player with Id 2: {}\n", playerRepository.getPlayerById(2));

        logger.info("\n\n>> Updating Player with Id 2: {}\n", playerRepository.updatePlayer(
                new Player(2, "Thiem", "Austria", Date.valueOf("1993-09-03"), 17)));

        logger.info("\n\n>> Player with Id 2: {}\n", playerRepository.getPlayerById(2));

        playerRepository.deletePlayerById(2);

        logger.info("\n\n>> All Players: {}\n", playerRepository.getAllPlayers());

    }
}
