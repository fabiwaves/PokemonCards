/**
 * @author Fabiwave
 */
import java.lang.Math;
public abstract class Type {

    protected String name;

    /**
     * Calculate the damage that is inflicted by a pokemon of the specified type
     *
     * @param type   Type of pokemon
     * @param damage Amount of damage inflicted
     * @return The damage inflicted by the pokemon
     */
    abstract public int calcDamage(Type type, int damage);

    /**
     * Calculate the damage inflicted by a Plant type
     *
     * @param damage Amount of damage inflicted
     * @return The damage inflicted by the pokemon
     */
    abstract public int calcDamagePlant(int damage);

    /**
     * Calculate the damage inflicted by a Fire type
     *
     * @param damage Amount of damage inflicted
     * @return The damage inflicted by the pokemon
     */
    abstract public int calcDamageFire(int damage);

    /**
     * Calculate the damage inflicted by a Water type
     *
     * @param damage Amount of damage inflicted
     * @return The damage inflicted by the pokemon
     */
    abstract public int calcDamageWater(int damage);

    /**
     * Calculate the damage inflicted by a Lightning type
     *
     * @param damage Amount of damage inflicted
     * @return The damage inflicted by the pokemon
     */
    abstract public int calcDamageLightning(int damage);

    /**
     * Calculate the damage inflicted by a Fighting type
     *
     * @param damage Amount of damage inflicted
     * @return The damage inflicted by the pokemon
     */
    abstract public int calcDamageFighting(int damage);

    /**
     * Calculate the damage inflicted by a Psychic type
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
