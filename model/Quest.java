package model;

public abstract class Quest {
    private int id;
    private String title;
    private String description;
    private int xpReward;
    private QuestStatus status;

    public Quest(int id, String title, String description, int xpReward, QuestStatus status) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.xpReward = xpReward;
        this.status = status;
    }
    public int getId() {
        return this.id;
    }
    public String getTitle() {
        return this.title;
    }
    public String getDescription() {
        return this.description;
    }
    public int getXpReward() {
        return this.xpReward;
    }
    public QuestStatus getStatus() {
        return this.status;
    }
    public void setStatus(QuestStatus status) {
        this.status = status;
    }
}
