package Other;

import java.util.HashMap;

/**
 * @author Fabiwave
 */

public class Attack extends AbstractAbility {
    private int damage;

    public Attack(String name, int damage, String description, HashMap<String, Integer> energies) {
        this.name = name;
        this.damage = damage;
        this.description = description;
        this.energies = energies;
    }

    /**
     * Gives the damage of the attack
     *
     * @return the damage of the attack
     */
    public int getDamage() {
        return damage;
    }

}
