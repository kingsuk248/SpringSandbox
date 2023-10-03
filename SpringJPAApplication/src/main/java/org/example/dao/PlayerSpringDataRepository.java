package org.example.dao;

import org.example.pojo.Player;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerSpringDataRepository extends JpaRepository<Player, Integer> {
}
