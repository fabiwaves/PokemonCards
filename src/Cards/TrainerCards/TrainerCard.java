package Cards.TrainerCards;

import Cards.AbstractCard;

public abstract class TrainerCard extends AbstractCard implements ITrainerCard {

    protected String description;

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
