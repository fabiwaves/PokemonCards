import Types.Fighting;
import Types.Lightning;
import Types.Type;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class LightningTest {
    private Lightning lightning;
    private Type otherType;
    private int damage1;
    private int damage2;

    @Before
    public void setUp() {
        lightning = new Lightning();
        otherType = new Fighting();
        damage1 = 2;
        damage2 = 32;
    }

    @Test
    public void calcDamage() {
        assertEquals(otherType.calcDamageLightning(damage1), lightning.calcDamage(otherType, damage1));
    }

    @Test
    public void calcDamagePlant() {
        assertEquals(damage1,lightning.calcDamagePlant(damage1));
        assertEquals(damage2,lightning.calcDamagePlant(damage2));
    }

    @Test
    public void calcDamageFire() {
        assertEquals(damage1,lightning.calcDamageFire(damage1));
        assertEquals(damage2,lightning.calcDamageFire(damage2));
    }

    @Test
    public void calcDamageWater() {
        assertEquals(damage1,lightning.calcDamageWater(damage1));
        assertEquals(damage2,lightning.calcDamageWater(damage2));
    }

    @Test
    public void calcDamageLightning() {
        assertEquals(damage1,lightning.calcDamageLightning(damage1));
        assertEquals(damage2,lightning.calcDamageLightning(damage2));
    }

    @Test
    public void calcDamageFighting() {
        assertEquals(damage1*2,lightning.calcDamageFighting(damage1));
        assertEquals(damage2*2,lightning.calcDamageFighting(damage2));
    }

    @Test
    public void calcDamagePsychic() {
        assertEquals(damage1,lightning.calcDamagePsychic(damage1));
        assertEquals(damage2,lightning.calcDamagePsychic(damage2));
    }
}