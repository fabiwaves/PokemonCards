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

}
