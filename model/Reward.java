package model;

public class Reward {
    private int level;
    private String title;
    public Reward(int level, String title) {
        this.level = level;
        this.title = title;
    }
    public int getLevel() {
        return this.level;
    }
    public String getTitle() {
        return this.title;
    }
}