package Other;

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
     * Gives the amount of energy requirement of an Energy
     *
     * @param nameEnergy Name of the energy that you want to know the requiremente
     * @return Integer with the number of energy necessary
     */
    public Integer getCost(String nameEnergy);

}
