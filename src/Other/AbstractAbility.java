package Other;

import Cards.ICard;

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

    public Integer getCost(String nameEnergy) {
        Integer cost = this.energies.get(nameEnergy);
        if (cost == null) {
            cost = 0;
        }
        return cost;
    }

    //public void use(ICard target,cost)


}
