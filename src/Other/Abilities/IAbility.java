package Other.Abilities;

import Cards.IPokemon;

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

    public boolean checkCost();

    IPokemon getPokemon();

    void useAbility();

}
