package Cartas;

public abstract class AbstractCard {

    String name;
    Trainer trainer;

    /**
     * Gives the name of the card
     *
     * @return the name of the card
     */
    public String getName() {
        return this.name;
    }

    /**
     * Gives the trainer associated to the card
     *
     * @return the trainer of the card
     */
    public Trainer getTrainer() {
        return this.trainer;
    }

    /**
     * Changes the name of the card
     *
     * @param name new name of the cards
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Sets the trainer associated to the card
     *
     * @param trainer new trainer of the card
     */
    public void setTrainer(Trainer trainer) {
        this.trainer = trainer;
    }

    /**
     * Represents the action of playing a card
     * It depends of the card type the effect of the play
     */
    public abstract void play();
}
