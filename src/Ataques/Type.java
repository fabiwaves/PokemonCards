package Ataques; /**
 * @author Fabiwave
 */
import java.lang.Math;
public abstract class Type {

    protected String name;

    /**
     * Calculate the damage that is inflicted by a pokemon of the specified type
     *
     * @param type   Ataques.Type of pokemon
     * @param damage Amount of damage inflicted
     * @return The damage inflicted by the pokemon
     */
    abstract public int calcDamage(Type type, int damage);

    /**
     * Calculate the damage inflicted by a Ataques.Plant type
     *
     * @param damage Amount of damage inflicted
     * @return The damage inflicted by the pokemon
     */
    abstract public int calcDamagePlant(int damage);

    /**
     * Calculate the damage inflicted by a Ataques.Fire type
     *
     * @param damage Amount of damage inflicted
     * @return The damage inflicted by the pokemon
     */
    abstract public int calcDamageFire(int damage);

    /**
     * Calculate the damage inflicted by a Ataques.Water type
     *
     * @param damage Amount of damage inflicted
     * @return The damage inflicted by the pokemon
     */
    abstract public int calcDamageWater(int damage);

    /**
     * Calculate the damage inflicted by a Ataques.Lightning type
     *
     * @param damage Amount of damage inflicted
     * @return The damage inflicted by the pokemon
     */
    abstract public int calcDamageLightning(int damage);

    /**
     * Calculate the damage inflicted by a Ataques.Fighting type
     *
     * @param damage Amount of damage inflicted
     * @return The damage inflicted by the pokemon
     */
    abstract public int calcDamageFighting(int damage);

    /**
     * Calculate the damage inflicted by a Ataques.Psychic type
     *
     * @param damage Amount of damage inflicted
     * @return The damage inflicted by the pokemon
     */
    abstract public int calcDamagePsychic(int damage);

    /**
     * Modify the damage of the attack simulating resistance to this
     *
     * @param damage
     * @return Effective damage
     */
    public int resistant(int damage) {
        return Math.max(damage - 30, 0);
    }

    /**
     * Modify the damage of the attack simulating weakness to this
     *
     * @param damage
     * @return Effective damage
     */
    public int weak(int damage) {
        return damage * 2;
    }
}
