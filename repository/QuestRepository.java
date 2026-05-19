package repository;

import model.Quest;
import model.DailyQuest;
import model.OneTimeQuest;
import model.QuestStatus;
import java.io.*;
import java.util.List;
import java.util.ArrayList;

public class QuestRepository {

    private static final String FILE_PATH = "data/quests.json";

    public void save(List<Quest> quests) {
        try (FileWriter writer = new FileWriter(FILE_PATH)) {
            StringBuilder json = new StringBuilder("[");
            for (int i = 0; i < quests.size(); i++) {
                Quest quest = quests.get(i);
                json.append("{ \"id\": ").append(quest.getId())
                    .append(", \"title\": \"").append(quest.getTitle()).append("\"")
                    .append(", \"description\": \"").append(quest.getDescription()).append("\"")
                    .append(", \"xpReward\": ").append(quest.getXpReward())
                    .append(", \"status\": \"").append(quest.getStatus()).append("\"")
                    .append(", \"type\": \"").append(quest instanceof DailyQuest ? "Daily" : "OneTime").append("\" }");
                if (i < quests.size() - 1) {
                    json.append(", ");
                }
            }
            json.append("]");
            writer.write(json.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Quest> load() {
            try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String json = reader.readLine();
            if (json != null) {
                List<Quest> quests = new ArrayList<>();
                String[] questEntries = json.substring(1, json.length() - 1).split("\\}, \\{");
                for (String entry : questEntries) {
                    String idStr = entry.split("\"id\": ")[1].split(",")[0];
                    String title = entry.split("\"title\": \"")[1].split("\"")[0];
                    String description = entry.split("\"description\": \"")[1].split("\"")[0];
                    String xpRewardStr = entry.split("\"xpReward\": ")[1].split(",")[0];
                    String statusStr = entry.split("\"status\": \"")[1].split("\"")[0];
                    String typeStr = entry.split("\"type\": \"")[1].split("\"")[0];

                    int id = Integer.parseInt(idStr);
                    int xpReward = Integer.parseInt(xpRewardStr);
                    QuestStatus status = QuestStatus.valueOf(statusStr);
                    Quest quest;
                    if (typeStr.equals("Daily")) {
                        quest = new DailyQuest(id, title, description, xpReward, status);
                    } else {
                        quest = new OneTimeQuest(id, title, description, xpReward, status);
                    }
                    quests.add(quest);
                }
                return quests;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }
}
