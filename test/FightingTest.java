import Ataques.Fighting;
import Ataques.Fire;
import Ataques.Type;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class FightingTest {
    private Fighting fighting;
    private Type otherType;
    private int damage1;
    private int damage2;

    @Before
    public void setUp() {
        fighting = new Fighting();
        otherType = new Fire();
        damage1 = 2;
        damage2 = 32;
    }

    @Test
    public void calcDamage() {
        assertEquals(otherType.calcDamageFighting(damage1), fighting.calcDamage(otherType, damage1));
    }

    @Test
    public void calcDamagePlant() {
        assertEquals(damage1*2,fighting.calcDamagePlant(damage1));
        assertEquals(damage2*2,fighting.calcDamagePlant(damage2));
    }

    @Test
    public void calcDamageFire() {
        assertEquals(damage1,fighting.calcDamageFire(damage1));
        assertEquals(damage2,fighting.calcDamageFire(damage2));
    }

    @Test
    public void calcDamageWater() {
        assertEquals(damage1,fighting.calcDamageWater(damage1));
        assertEquals(damage2,fighting.calcDamageWater(damage2));
    }

    @Test
    public void calcDamageLightning() {
        assertEquals(damage1,fighting.calcDamageLightning(damage1));
        assertEquals(damage2,fighting.calcDamageLightning(damage2));
    }

    @Test
    public void calcDamageFighting() {
        assertEquals(damage1,fighting.calcDamageFighting(damage1));
        assertEquals(damage2,fighting.calcDamageFighting(damage2));
    }

    @Test
    public void calcDamagePsychic() {
        assertEquals(damage1*2,fighting.calcDamagePsychic(damage1));
        assertEquals(damage2*2,fighting.calcDamagePsychic(damage2));
    }
}