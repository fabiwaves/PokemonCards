
public class Psychic extends Type {

    public Psychic(){
        name = "Psychic";
    }

    @Override
    public int calcDamage(Type type, int damage) {
        return type.calcDamagePsychic(damage);
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
    public int calcDamageFighting(int damage) {
        return super.resistant(damage);
    }

    @Override
    public int calcDamagePsychic(int damage) {
        return super.weak(damage);
    }
}