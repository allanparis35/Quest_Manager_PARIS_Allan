package repository;

import model.Player;
import java.io.*;

public class PlayerRepository {

    private static final String FILE_PATH = "data/player.json";

    public void save(Player player) {
        try (FileWriter writer = new FileWriter(FILE_PATH)) {
           
            String json = "{ \"name\": \"" + player.getName() + "\", \"level\": " + player.getLevel() + ", \"currentXP\": " + player.getCurrentXP() + ", \"totalXP\": " + player.getTotalXP() + ", \"title\": \"" + player.getTitle() + "\" }";
            writer.write(json);
        } catch (IOException e) {
            e.printStackTrace();   
    }
}

    public Player load() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String json = reader.readLine();
            if (json != null) {
                String name = json.split("\"name\": \"")[1].split("\"")[0];
                int level = Integer.parseInt(json.split("\"level\": ")[1].split(",")[0]);
                int currentXP = Integer.parseInt(json.split("\"currentXP\": ")[1].split(",")[0]);
                int totalXP = Integer.parseInt(json.split("\"totalXP\": ")[1].split(",")[0]);
                String title = json.split("\"title\": \"")[1].split("\"")[0];
                Player player = new Player(name);
                player.setLevel(level);
                player.setCurrentXP(currentXP);
                player.setTitle(title);
                return player;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    }
