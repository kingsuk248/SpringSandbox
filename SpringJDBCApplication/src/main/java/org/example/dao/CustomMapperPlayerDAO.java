package org.example.dao;

import org.example.pojo.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class CustomMapperPlayerDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    private static final class PlayerMapper implements RowMapper<Player> {

        @Override
        public Player mapRow(ResultSet resultSet, int rowNum) throws SQLException {
            Player player = new Player();
            player.setId(resultSet.getInt("id"));
            player.setName(resultSet.getString("name"));
            player.setNationality(resultSet.getString("nationality"));
            player.setBirthDate(resultSet.getTime("birth_date"));
            player.setTitles(resultSet.getInt("titles"));
            return player;
        }
    }

    public List<Player> getPlayerByNationality(String nationality) {
        String sql = "SELECT * FROM player WHERE nationality = ?";
        RowMapper<Player> rowMapper = new PlayerMapper();
        return jdbcTemplate.query(sql, rowMapper, nationality);

    }
}
