package controller;

import model.Quest;
import model.DailyQuest;
import model.OneTimeQuest;
import model.QuestStatus;
import repository.QuestRepository;
import exception.InvalidQuestException;
import java.util.List;
import java.util.ArrayList;
import java.time.LocalDate;

public class QuestController {

    private List<Quest> quests;
    private QuestRepository repository;

    public QuestController() {
        this.repository = new QuestRepository();
        this.quests = this.repository.load();
    }

    public List<Quest> getQuests() {
        return this.quests;
    }

    public void createQuest(Quest quest) throws InvalidQuestException {
        if (quest.getTitle() == null || quest.getTitle().isEmpty()) {
    throw new InvalidQuestException("Le titre ne peut pas être vide");
}
        if (quest.getXpReward() <= 0 || quest.getXpReward() > 1000) {
    throw new InvalidQuestException("XP doit être entre 1 et 1000");
}
        if (quest.getTitle().length() > 50) {
    throw new InvalidQuestException("Titre trop long (max 50 caractères)");
}
        this.quests.add(quest);
    }

    public void deleteQuest(int id) {
        this.quests.removeIf(q -> q.getId() == id);
    }

    public void completeQuest(int id) {
        for (Quest q : this.quests) {
            if (q.getId() == id) {
                q.setStatus(QuestStatus.DONE);
            if (q instanceof DailyQuest) {
                ((DailyQuest) q).setLastCompletedDate(LocalDate.now());
            }
            break;
            }
        }
    }
    public void save() {
        this.repository.save(this.quests);
    }
}