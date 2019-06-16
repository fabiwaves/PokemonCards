package Cards.TrainerCards;

import Cards.AbstractCard;

/**
 * @author fabiwave
 */

public abstract class TrainerCard extends AbstractCard implements ITrainerCard {

    private String description;

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
