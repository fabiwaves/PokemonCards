/**
 * @author Fabiwave
 */

import java.util.HashMap;

public class Attack {

    protected String name;
    protected int damage;
    protected String description;
    protected HashMap<String, Integer> energies;


    public Attack(String name, int damage, String description, HashMap<String, Integer> energies) {
        this.name = name;
        this.damage = damage;
        this.description = description;
        this.energies = energies;
    }

    /**
     * Gives the name of the attack
     *
     * @return the name of the attack
     */
    public String getName() {
        return name;
    }

    /**
     * Gives the damage of the attack
     *
     * @return the damage of the attack
     */
    public int getDamage() {
        return damage;
    }

    /**
     * Gives the Hashmap op the energies required for the attack
     *
     * @return energies of the pokemon
     */
    public HashMap<String, Integer> getEnergies() {
        return energies;
    }

    /**
     * Gives the description of the attack
     *
     * @return the description of the attack
     */
    public String getDescription() {
        return description;
    }

    /**
     * Gives the amount of energy requirement of an Energy
     *
     * @param nameEnergy Name of the energy that you want to know the requiremente
     * @return Integer with the number of energy necessary
     */
    public Integer getCost(String nameEnergy) {
        Integer cost = this.energies.get(nameEnergy);
        if (cost == null) {
            cost = new Integer(0);
        }
        return cost;
    }

}
