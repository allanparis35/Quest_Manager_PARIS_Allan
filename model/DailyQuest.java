package model;
import java.time.LocalDate;

//Daily quest that resets every day
public class DailyQuest extends Quest {
    private LocalDate lastCompletedDate;

    public DailyQuest(String title, String description, int xpReward, QuestStatus status) {
        super(title, description, xpReward, QuestStatus.TODO);
        this.lastCompletedDate = null;
    }
    //Resets the quest if it was completed on a previous day
    public void reset() {
        if (this.lastCompletedDate == null || this.lastCompletedDate.isBefore(LocalDate.now())) {
            this.setStatus(QuestStatus.TODO);
            this.lastCompletedDate = null;
        }
    }


    public LocalDate getLastCompletedDate() {
        return this.lastCompletedDate;
    }

   
    public void setLastCompletedDate(LocalDate date) {
        this.lastCompletedDate = date;
    }
}
