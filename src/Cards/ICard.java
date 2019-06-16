package Cards;

import Controller.Game;
import Players.Trainer;

/**
 * @author fabiwave
 */

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
     * Notifies the type of the card to the controller
     *
     * @param game controller that has to be notified
     */
    void notifyType(Game game);
}
