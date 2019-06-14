package Cards.Phases;

public interface IPhase {

    /**
     * Gives the id of the pokemon that comes before it
     * @return the id of the pokemon or -1 if it doesnt exist
     */
    public int getPrev_pokemon_id();

    /**
     * Gives the id of the pokemon that comes before it (2nd level)
     * @return the id of the pokemon or -1 if it doesnt exist
     */
    public int getPrev_pokemon_id2();

    /**
     * Sets the previous pokemon to the phase
     * @param prev_pokemon_id1 id of the pokemon that comes before this one
     */
    public void setPrev_pokemon_id1(int prev_pokemon_id1);

    /**
     * Sets the previous pokemon to the phase
     * @param prev_pokemon_id2 id of the pokemon that comes before this one
     */
    public void setPrev_pokemon_id2(int prev_pokemon_id2);
}
