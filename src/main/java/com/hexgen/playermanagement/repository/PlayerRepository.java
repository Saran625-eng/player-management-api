package com.hexgen.playermanagement.repository;

import com.hexgen.playermanagement.entity.Player;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerRepository extends JpaRepository<Player, Long> {

}