package Players;

import Cards.ICard;
import Cards.IPokemon;

import java.util.ArrayList;

/**
 * @author fabiwave
 */

public interface Player {

    /**
     * Gives the active pokemon
     *
     * @return Cards.Pokemon
     */
    IPokemon getActivePokemon();

    /**
     * Changes the active pokemon to the given one
     *
     * @param activePokemon new active pokemon
     */
    void setActivePokemon(IPokemon activePokemon);

    /**
     * Gives the collection of the pokemon (the hand of the player)
     *
     * @return ArrayList with the pokemon in the bench
     */
    ArrayList<ICard> getHand();

    /**
     * Changes the current hand for the given one
     *
     * @param hand new hand
     */
    void setHand(ArrayList<IPokemon> hand);

    public ArrayList<ICard> getDeck();

    /**
     * Gives the collection of all the pokemon of the player
     *
     * @return ArrayList with the pokemon that the Players.Trainer has
     */
    ArrayList<IPokemon> getTeam();

    /**
     * Changes the active pokemon to the next one in the hand
     */
    void replaceActivePokemon();

    /**
     * Checks if active pokemon is still alive
     */
    void checkActivePokemon();

    /**
     * Add a played pokemon card to the the team
     */
    public void addPokemonToTeam();

    /**
     * Select an attack of a pokemon
     *
     * @param index of the attack that you want to use
     */
    public void selectAbility(int index);

    /**
     * Uses a selected ability
     *
     * @param index of the number of the ability that wants to be selected
     */
    public void useAbility(int index);

    /**
     * Select the pokemon as its own target
     *
     * @return the pokemon selected as own target
     */
    public IPokemon selectOwnPokemonTarget();

    /**
     * Gives the enemy target
     *
     * @return the IPokemon that it is a target
     */
    public IPokemon selectEnemyPokemonTarget();

    /**
     * Sekect a trainer as a target
     *
     * @return return the target trainer
     */
    public Player selectTrainerTarget();

    /**
     * Simulates the action of playing a card
     *
     * @param card that you want to play
     */
    public void play(ICard card);

    /**
     * Simulates playing a card
     */
    void playACard();

    /**
     * Sends a card from any place to the cemetery pile
     *
     * @param card  Card that you want to send to the graveyard
     * @param place Location of the card
     */
    public <T> void sendToGraveyard(T card, ArrayList<T> place);

    /**
     * Notifies to the controller (game) that the player has made an attack
     */
    public void notifyAttack();

    /**
     * Notifies the observer that the turn has ended
     */
    public void endTurn();

    /**
     * Gets the first card of a Player deck
     */
    public void getCard();

}
