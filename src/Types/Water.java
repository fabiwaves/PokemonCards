package Types;

/**
 * @author Fabiwave
 */

public class Water extends Type {

    public Water() {
        this.name = "Water";
    }

    @Override
    public int calcDamage(Type type, int damage) {
        return type.calcDamageWater(damage);
    }

    @Override
    public int calcDamagePlant(int damage) {
        return super.weak(damage);
    }

    @Override
    public int calcDamageFire(int damage) {
        return damage;
    }

    @Override
    public int calcDamageWater(int damage) {
        return damage;
    }

    @Override
    public int calcDamageLightning(int damage) {
        return super.weak(damage);
    }

    @Override
    public int calcDamageFighting(int damage) {
        return super.resistant(damage);
    }

    @Override
    public int calcDamagePsychic(int damage) {
        return damage;
    }
}
