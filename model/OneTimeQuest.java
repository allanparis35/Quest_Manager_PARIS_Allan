package model;

//This is a one-time quest. Once completed, it does not reset.
public class OneTimeQuest extends Quest {
public OneTimeQuest(int id, String title, String description, int xpReward, QuestStatus status) {
    super(id, title, description, xpReward, status);
}
}
