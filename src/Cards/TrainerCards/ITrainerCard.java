package Cards.TrainerCards;

import Cards.ICard;

/**
 * @author fabiwave
 */

public interface ITrainerCard extends ICard {

    /**
     * Gives the description of the trainerCard
     *
     * @return the description of the trainerCard
     */
    public String getDescription();


    /**
     * Sets the description of a trainerCard
     *
     * @param description that wants to set
     */
    public void setDescription(String description);
}

