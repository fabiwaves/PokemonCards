
public class Fire extends Type {

    public Fire(){
        this.name = "Fire";
    }

    @Override
    public int calcDamage(Type type, int damage) {
        return type.calcDamageFire(damage);
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
        return super.weak(damage);
    }

    @Override
    public int calcDamageLightning(int damage) {
        return damage;
    }

    @Override
    public int calcDamageFighting(int damage) {
        return damage;
    }

    @Override
    public int calcDamagePsychic(int damage) {
        return damage;
    }
}