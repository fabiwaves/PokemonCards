package Cards;

import Players.Trainer;

/**
 * @author fabiwave
 */

public abstract class AbstractCard implements ICard {

    private String name;
    private Trainer trainer;

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Trainer getTrainer() {
        return this.trainer;
    }

    public void setTrainer(Trainer trainer) {
        this.trainer = trainer;
    }
}
