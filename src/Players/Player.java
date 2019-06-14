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

    /**
     * Gives the collection of all the pokemon of the player
     *
     * @return ArrayList with the pokemon that the Players.Trainer has
     */
    ArrayList<IPokemon> getTeam();

    /**
     * Changes the active pokemon to the next one in the hand
     */
    void changeActivePokemon();

    /**
     * Checks if active pokemon is still alive
     */
    void checkActivePokemon();

    /**
     * Sends a card from any place to the cemetery pile
     *
     * @param card  Card that you want to send to the cemetery
     * @param place Location of the card
     */
    public void sendToGraveyard(ICard card, ArrayList<ICard> place);

    /**
     * Add a pokemon to the the team
     *
     * @param pokemon that you want to add to the team
     */
    public void addPokemonToTeam(IPokemon pokemon);

    /**
     * Select an attack of a pokemon
     *
     * @param index of the attack that you want to use
     */
    public void selectAttack(int index);

    /**
     * Attacks an enemy
     *
     * @param adversary that you want to attack
     */
    public void attackEnemy(Player adversary);

    /**
     * Simulates the action of playing a card
     *
     * @param card that you want to play
     */
    public void play(ICard card);
}
