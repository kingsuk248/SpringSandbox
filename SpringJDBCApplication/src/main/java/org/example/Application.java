package org.example;

import org.example.dao.CustomMapperPlayerDAO;
import org.example.dao.PlayerDAO;
import org.example.pojo.Player;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Date;

@SpringBootApplication
public class Application implements CommandLineRunner {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Autowired
    private PlayerDAO playerDAO;

    @Autowired
    private CustomMapperPlayerDAO customPlayerDAO;

    @Override
    public void run(String... args) throws Exception {
        logger.info("All Players Data: {}", playerDAO.getAllPlayers());
        logger.info("Player by ID: {}", playerDAO.getPlayerById(2));
        logger.info("Player by ID and Name: {}", playerDAO.getPlayerByIdAndName(3, "Isner"));
        logger.info("Inserting Player 4: {}", playerDAO.insertPlayer(
                new Player(4, "Thiem", "Austria",
                        new Date(System.currentTimeMillis()),
                        17)));
        logger.info("All Players Data: {}", playerDAO.getAllPlayers());

        logger.info("Updating Player with Id 4: {}", playerDAO.updatePlayer(
                new Player(4, "Thiem", "Austria",
                        Date.valueOf("1993-09-03"), 17)));
        logger.info("Player by ID: {}", playerDAO.getPlayerById(4));

        logger.info("Deleting Player with Id 4: {}", playerDAO.deletePlayerById(4));
        logger.info("All Players Data: {}", playerDAO.getAllPlayers());

        logger.info("Creating Tournament Table ...");
        playerDAO.createTournamentTable();

        logger.info("French Players: {}", customPlayerDAO.getPlayerByNationality("France"));

    }
}
