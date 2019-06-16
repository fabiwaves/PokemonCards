package Types;

/**
 * @author Fabiwave
 */

public abstract class Type {

    protected String name;

    public String getName() {
        return this.name;
    }

    /**
     * Calculate the damage that is inflicted by a pokemon of the specified type
     *
     * @param type   Types.Type of pokemon
     * @param damage Amount of damage inflicted
     * @return The damage inflicted by the pokemon
     */
    abstract public int calcDamage(Type type, int damage);

    /**
     * Calculate the damage inflicted by a Types.Plant type
     *
     * @param damage Amount of damage inflicted
     * @return The damage inflicted by the pokemon
     */
    abstract public int calcDamagePlant(int damage);

    /**
     * Calculate the damage inflicted by a Types.Fire type
     *
     * @param damage Amount of damage inflicted
     * @return The damage inflicted by the pokemon
     */
    abstract public int calcDamageFire(int damage);

    /**
     * Calculate the damage inflicted by a Types.Water type
     *
     * @param damage Amount of damage inflicted
     * @return The damage inflicted by the pokemon
     */
    abstract public int calcDamageWater(int damage);

    /**
     * Calculate the damage inflicted by a Types.Lightning type
     *
     * @param damage Amount of damage inflicted
     * @return The damage inflicted by the pokemon
     */
    abstract public int calcDamageLightning(int damage);

    /**
     * Calculate the damage inflicted by a Types.Fighting type
     *
     * @param damage Amount of damage inflicted
     * @return The damage inflicted by the pokemon
     */
    abstract public int calcDamageFighting(int damage);

    /**
     * Calculate the damage inflicted by a Types.Psychic type
     *
     * @param damage Amount of damage inflicted
     * @return The damage inflicted by the pokemon
     */
    abstract public int calcDamagePsychic(int damage);

    /**
     * Modify the damage of the attack simulating resistance to this
     *
     * @param damage the attack damage before resistance calculation
     * @return Effective damage
     */
    int resistant(int damage) {
        return Math.max(damage - 30, 0);
    }

    /**
     * Modify the damage of the attack simulating weakness to this
     *
     * @param damage he attack damage before weakness calculation
     * @return Effective damage
     */
    int weak(int damage) {
        return damage * 2;
    }
}
