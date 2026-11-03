package com.hexgen.playermanagement.controller;

import com.hexgen.playermanagement.entity.Player;
import com.hexgen.playermanagement.service.PlayerService;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/players")
@CrossOrigin(origins = "*")
public class PlayerController {

    private final PlayerService playerService;

    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    // Create player
    @PostMapping
    public Player createPlayer(@RequestBody Player player) {
        return playerService.createPlayer(player);
    }

    // Get all players
    @GetMapping
    public List<Player> getAllPlayers() {
        return playerService.getAllPlayers();
    }

    // Get player by ID
    @GetMapping("/{id}")
    public Player getPlayerById(@PathVariable Long id) {
        return playerService.getPlayerById(id);
    }

    // Update player
    @PutMapping("/{id}")
    public Player updatePlayer(@PathVariable Long id,
                               @RequestBody Player player) {
        return playerService.updatePlayer(id, player);
    }

    // Delete player
    @DeleteMapping("/{id}")
    public String deletePlayer(@PathVariable Long id) {
        playerService.deletePlayer(id);
        return "Player deleted successfully";
    }
}