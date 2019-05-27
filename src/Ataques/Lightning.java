package Ataques;

/**
 * @author Fabiwave
 */
public class Lightning extends Type {

    public Lightning(){
        this.name = "Ataques.Lightning";
    }

    @Override
    public int calcDamage(Type type, int damage) {
        return type.calcDamageLightning(damage);
    }

    @Override
    public int calcDamagePlant(int damage) {
        return damage;
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
        return damage;
    }

    @Override
    // Damage that fighting type does to lightning
    public int calcDamageFighting(int damage) {
        return super.weak(damage);
    }

    @Override
    // Damage that psychic type does to lightning
    public int calcDamagePsychic(int damage) {
        return damage;
    }
}
