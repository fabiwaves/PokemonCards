public class Plant extends Type {

    @Override
    public int calcDamage(Type type, int damage) {
        return type.calcDamagePlant(damage);
    }

    @Override
    public int calcDamagePlant(int damage) {
        return super.resistant(damage);
    }

    @Override
    public int calcDamageFire(int damage) {
        return super.weak(damage);
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
    // Damage that fighting type does to
    public int calcDamageFighting(int damage) {
        return damage;
    }

    @Override
    // Damage that psychic type does to
    public int calcDamagePsychic(int damage) {
        return damage;
    }
}