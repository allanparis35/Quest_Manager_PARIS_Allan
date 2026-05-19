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

    public void addXP(int xp) {
        this.currentXP += xp;
        this.totalXP += xp;
        if (this.currentXP >= XP_PER_LEVEL) {
            this.levelUp();

        }   
            }
    private void levelUp() {
        while (this.currentXP >= XP_PER_LEVEL && this.level < MAX_LEVEL) {
            this.level++;
            this.currentXP -= XP_PER_LEVEL;
            this.updateTitle();
        }
    }


    private void updateTitle() {
        if (this.level >= 30) {
            this.title = "digne de la madré";
        } else if (this.level >= 25) {
            this.title = "Seigneur du Bordel Organisé";
        } else if (this.level >= 20) {
            this.title = "Philosophe de la Sieste";
        } else if (this.level >= 15) {
            this.title = "pause café";
        } else if (this.level >= 10) {
            this.title = "tkt demain c'est fait";
        } else {
            this.title = "Mode Végétatif";
        }
    }
}
        

    