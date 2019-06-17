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
    int getPrev_pokemon_id();

    /**
     * Gives the id of the pokemon that comes before it (2nd level)
     *
     * @return the id of the pokemon or -1 if it doesn't exist
     */
    int getPrev_pokemon_id2();

    /**
     * Check if the prev_id1 it is the same as the id of the pokemon
     *
     * @param pokemon that want to be checked
     * @return true if it is the pre evolution, false otherwise
     */
    boolean checkPrevId1(IPokemon pokemon);

    /**
     * Check if the prev_id2 it is the same as the id of the pokemon
     *
     * @param pokemon that want to be checked
     * @return true if it is the pre-pre-evolution, false otherwise
     */
    boolean checkPrevId2(IPokemon pokemon);

    /**
     * Inform if a type is an evolution or not
     *
     * @return false if its a basic phase, false otherwise
     */
    boolean isEvolution();
}
