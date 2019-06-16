package Cards.Phases;

import Cards.IPokemon;

/**
 * @author fabiwave
 */

public interface IPhase {

    /**
     * Gives the id of the pokemon that comes before it
     *
     * @return the id of the pokemon or -1 if it doesnt exist
     */
    public int getPrev_pokemon_id();

    /**
     * Gives the id of the pokemon that comes before it (2nd level)
     *
     * @return the id of the pokemon or -1 if it doesnt exist
     */
    public int getPrev_pokemon_id2();

    /**
     * Sets the previous pokemon to the phase
     *
     * @param prev_pokemon_id2 id of the pokemon that comes before this one
     */
    public void setPrev_pokemon_id2(int prev_pokemon_id2);

    /**
     * Sets the previous pokemon to the phase
     *
     * @param prev_pokemon_id1 id of the pokemon that comes before this one
     */
    public void setPrev_pokemon_id1(int prev_pokemon_id1);

    /**
     * Check if the prev_id1 it is the same as the id of the pokemon
     *
     * @param pokemon that want to be checkes
     * @return true if it is the pre evolution, false otherwise
     */
    public boolean checkPrevId1(IPokemon pokemon);

    /**
     * Check if the prev_id2 it is the same as the id of the pokemon
     *
     * @param pokemon that want to be checkes
     * @return true if it is the pre-pre-evolution, false otherwise
     */
    public boolean checkPrevId2(IPokemon pokemon);

    /**
     * Inform if a type is an evolution or not
     *
     * @return false if its a basic phase, false otherwise
     */
    public boolean isEvolution();
}
