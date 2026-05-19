package controller;

import model.Player;
import repository.PlayerRepository;

public class PlayerController {

    private Player player;
    private PlayerRepository repository;

    public PlayerController() {
        this.repository = new PlayerRepository();
        this.player = this.repository.load();
    }

    public Player getPlayer() {
        return this.player;
    }

    public void addXP(int xp) {
        this.player.addXP(xp);
    }

    public void save() {
        this.repository.save(this.player);
    }
}
