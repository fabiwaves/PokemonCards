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
     * Gives the description of the attack
     *
     * @return the description of the attack
     */
    public String getDescription() {
        return description;
    }

    public Integer getCost(String energy) {
        Integer cost = this.energies.get(energy);
        if (cost == null) {
            cost = new Integer(0);
        }
        return cost;
    }

}
