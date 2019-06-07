package Cards;

import Players.Trainer;

public interface ICard {

    /**
     * Gives the name of the card
     *
     * @return the name of the card
     */
    String getName();

    /**
     * Changes the name of the card
     *
     * @param name new name of the cards
     */
    void setName(String name);

    /**
     * Gives the trainer associated to the card
     *
     * @return the trainer of the card
     */
    Trainer getTrainer();

    /**
     * Sets the trainer associated to the card
     *
     * @param trainer new trainer of the card
     */
    void setTrainer(Trainer trainer);

    /**
     * Represents the action of playing a card
     * It depends of the card type the effect of the play
     */
    void play();
}
