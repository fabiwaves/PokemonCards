package Other.Abilities;

import Cards.IPokemon;

/**
 * @author fabiwave
 */

public interface IAbility {

    /**
     * Gives the name of the attack
     *
     * @return the name of the attack
     */
    public String getName();

    /**
     * Gives the description of the attack
     *
     * @return the description of the attack
     */
    public String getDescription();

    /**
     * Chacks the cost of energies
     *
     * @return true if it can be afforded, false otherwise
     */
    public boolean checkCost();

    /**
     * Gets the pokemon associated to the ability
     *
     * @return IPokemon associated to the ability
     */
    IPokemon getPokemon();

    /**
     * Representation of using the ability
     */
    void useAbility();

}
