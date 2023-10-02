package org.example.dao;

import org.example.pojo.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;

@Repository
public class PlayerDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Player> getAllPlayers() {
        String sql = "SELECT * FROM Player";
        RowMapper<Player> rowMapper = new BeanPropertyRowMapper<Player>(Player.class);
        return jdbcTemplate.query(sql, rowMapper);
    }

    public Player getPlayerById(int id) {
        String sql = "SELECT * FROM Player WHERE id = ?";
        RowMapper<Player> rowMapper = new BeanPropertyRowMapper<>(Player.class);
        return jdbcTemplate.queryForObject(sql, rowMapper, id);
    }

    public Player getPlayerByIdAndName(int id, String name) {
        String sql = "SELECT * FROM Player WHERE id = ? AND name = ?";
        RowMapper<Player> rowMapper = new BeanPropertyRowMapper<>(Player.class);
        return jdbcTemplate.queryForObject(sql, rowMapper, id, name);
    }

    public int insertPlayer(Player player) {
        String sql = "INSERT INTO PLAYER (ID, Name, Nationality,Birth_date, Titles) " +
                "VALUES (?, ?, ?, ?, ?)";
        return jdbcTemplate.update(sql, new Object[]{
                player.getId(), player.getName(), player.getNationality(),
                new Timestamp(player.getBirthDate().getTime()), player.getTitles()});
    }

    public int updatePlayer(Player player) {
        String sql = "UPDATE PLAYER " +
                "SET Name = ?, Nationality = ?, Birth_date = ? , Titles = ? " +
                "WHERE ID = ?";
        return jdbcTemplate.update(sql, new Object[]{
                player.getName(),
                player.getNationality(),
                new Timestamp(player.getBirthDate().getTime()),
                player.getTitles(),
                player.getId()});
    }

    public int deletePlayerById(int id) {
        String sql = "DELETE FROM Player WHERE id = ?";
        return jdbcTemplate.update(sql, id);
    }

    public void createTournamentTable() {
        String sql = "CREATE TABLE TOURNAMENT (ID INTEGER, NAME VARCHAR(50), " +
                "LOCATION VARCHAR(50), PRIMARY KEY (ID))";
        jdbcTemplate.execute(sql);
    }
}
