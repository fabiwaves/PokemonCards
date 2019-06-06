package Jugador; /**
 * @author fabiwave
 */

import Cartas.AbstractCard;
import Cartas.IPokemon;

import java.util.ArrayList;

public interface Player {

    /**
     * Gives the active pokemon
     *
     * @return Cartas.Pokemon
     */
    public IPokemon getActivePokemon();

    /**
     * Gives the collection of the pokemon (the hand of the player)
     *
     * @return ArrayList with the pokemon in the bench
     */
    public ArrayList<AbstractCard> getHand();

    /**
     * Gives the collection of all the pokemon of the player
     *
     * @return ArrayList with the pokemon that the Jugador.Trainer has
     */
    public ArrayList<IPokemon> getTeam();

    /**
     * Changes the active pokemon to the given one
     *
     * @param activePokemon new active pokemon
     */
    public void setActivePokemon(IPokemon activePokemon);

    /**
     * Changes the current team to the given one
     *
     * @param team Collection of pokemon
     */
    public void setTeam(ArrayList<IPokemon> team);

    /**
     * Changes the current hand for the given one
     *
     * @param hand new hand
     */
    public void setHand(ArrayList<IPokemon> hand);

    /**
     * Changes the active pokemon to the next one in the hand
     */
    public void changeActivePokemon();

}
