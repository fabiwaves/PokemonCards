package Abilities.Abilities;

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
    String getName();

    /**
     * Gives the description of the attack
     *
     * @return the description of the attack
     */
    String getDescription();

    /**
     * Chacks the cost of energies
     *
     * @return true if it can be afforded, false otherwise
     */
    boolean checkCost();

    /**
     * Sets the pokemon associated to the ability
     *
     * @param pokemon IPokemon associated to the ability
     */
    void setPokemon(IPokemon pokemon);

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
