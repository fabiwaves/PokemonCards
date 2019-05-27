package Jugador; /**
 * @author fabiwave
 */

import Cartas.Pokemon;

import java.util.ArrayList;

public interface Player {

    /**
     * Gives the active pokemon
     *
     * @return Cartas.Pokemon
     */
    public Pokemon getActivePokemon();

    /**
     * Gives the collection of the pokemon (the hand of the player)
     *
     * @return ArrayList with the pokemon in the bench
     */
    public ArrayList<Pokemon> getHand();

    /**
     * Gives the collection of all the pokemon of the player
     *
     * @return ArrayList with the pokemon that the Jugador.Trainer has
     */
    public ArrayList<Pokemon> getTeam();

    /**
     * Changes the active pokemon to the given one
     *
     * @param activePokemon new active pokemon
     */
    public void setActivePokemon(Pokemon activePokemon);

    /**
     * Changes the current team to the given one
     *
     * @param team Collection of pokemon
     */
    public void setTeam(ArrayList<Pokemon> team);

    /**
     * Changes the current hand for the given one
     *
     * @param hand new hand
     */
    public void setHand(ArrayList<Pokemon> hand);

    /**
     * Changes the active pokemon to the next one in the hand
     */
    public void changeActivePokemon();

}
