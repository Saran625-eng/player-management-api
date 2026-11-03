package com.hexgen.playermanagement.service;

import com.hexgen.playermanagement.entity.Player;
import com.hexgen.playermanagement.repository.PlayerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerService {

    private final PlayerRepository playerRepository;

    public PlayerService(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    public Player createPlayer(Player player) {
        return playerRepository.save(player);
    }

    public List<Player> getAllPlayers() {
        return playerRepository.findAll();
    }

    public Player getPlayerById(Long id) {
        return playerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Player not found"));
    }

    public Player updatePlayer(Long id, Player player) {
        Player existing = getPlayerById(id);

        existing.setPlayerName(player.getPlayerName());
        existing.setEmail(player.getEmail());
        existing.setMobileNumber(player.getMobileNumber());
        existing.setAge(player.getAge());
        existing.setGender(player.getGender());
        existing.setProfileImage(player.getProfileImage());
        existing.setAddress(player.getAddress());

        return playerRepository.save(existing);
    }

    public void deletePlayer(Long id) {
        Player player = getPlayerById(id);
        playerRepository.delete(player);
    }
}