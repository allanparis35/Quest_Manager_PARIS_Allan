package model;

//This is a one-time quest. Once completed, it does not reset.
public class OneTimeQuest extends Quest {
public OneTimeQuest(String title, String description, int xpReward) {
    super(title, description, xpReward, QuestStatus.TODO);
}
}
