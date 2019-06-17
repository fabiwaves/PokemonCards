package Cards.TrainerCards;

import Cards.ICard;

/**
 * @author fabiwave
 */

interface ITrainerCard extends ICard {

    /**
     * Gives the description of the trainerCard
     *
     * @return the description of the trainerCard
     */
    String getDescription();


    /**
     * Sets the description of a trainerCard
     *
     * @param description that wants to set
     */
    void setDescription(String description);
}

