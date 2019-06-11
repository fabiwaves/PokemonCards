package Other;

import java.util.HashMap;

public abstract class AbstractAbility implements IAbility{
    String name;
    String description;
    HashMap<String, Integer> energies;

    public String getName() {
        return name;
    }

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
            cost = 0;
        }
        return cost;
    }
}
