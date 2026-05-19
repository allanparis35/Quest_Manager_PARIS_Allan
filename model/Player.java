package model;

public class Player {
    private String name;
    private int level;
    private int currentXP;
    private int totalXP;
    private String title;
    private static final int XP_PER_LEVEL = 100;
    private static final int MAX_LEVEL = 30;

    public Player(String name) {
        this.name = name;
        this.level = 1;
        this.currentXP = 0;
        this.totalXP = 0;
        this.title = "Mode Végétatif";
    }
    public String getName() {
        return this.name;
    }
    public int getLevel() {
        return this.level;
    }
    public int getCurrentXP() {
        return this.currentXP;
    }
    public int getTotalXP() {
        return this.totalXP;
    }
    public String getTitle() {
        return this.title;
    }
    public void setLevel(int level) {
    this.level = level;
}

public void setCurrentXP(int currentXP) {
    this.currentXP = currentXP;
}

public void setTitle(String title) {
    this.title = title;
}

    public void addXP(int xp) {
    this.currentXP += xp;
    this.totalXP += xp;
    levelUp();
    }
    private void levelUp() {
        while (this.currentXP >= XP_PER_LEVEL && this.level < MAX_LEVEL) {
            this.level++;
            this.currentXP -= XP_PER_LEVEL;
            this.updateTitle();
        }
    }

    private static final Reward[] REWARDS = {
    new Reward(1, "Mode Végétatif"),
    new Reward(6, "tkt demain c'est fait"),
    new Reward(11, "pause café"),
    new Reward(16, "Philosophe de la Sieste"),
    new Reward(21, "Seigneur du Bordel Organisé"),
    new Reward(26, "digne de la madré")
};

    private void updateTitle() {
    for (int i = REWARDS.length - 1; i >= 0; i--) {
        if (this.level >= REWARDS[i].getLevel()) {
            this.title = REWARDS[i].getTitle();
            break;
        }
        }
    }
}
        

    