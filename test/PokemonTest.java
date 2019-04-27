import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class PokemonTest {

    public Pokemon piplup;

    @Before
    public void setUp() {
        //Array for the abilities
        ArrayList<String> abilities = new ArrayList<>();
        abilities.add("Bubble Beam");
        abilities.add("Brine");
        abilities.add("Whirlpool");
        abilities.add("Hydro Pump");
        //Array for the energies
        ArrayList<Energy> energies = new ArrayList<>();
        Energy energy = new Energy("name","type");
        energies.add(energy);
        //Initialization of type
        Water water = new Water();
        //Initialization of piplup
        piplup = new Pokemon("Piplup", 393, 70, abilities, energies, water);

    }

    @Test
    public void testGetName() {
        assertEquals("Piplup", piplup.getName());
        assertEquals(piplup.name, piplup.getName());
    }

    @Test
    public void testGetId() {
        assertEquals(393,piplup.getId());
        assertEquals(piplup.id,piplup.getId());
    }

    @Test
    public void testGetHp() {
        assertEquals(70,piplup.getHp());
        assertEquals(piplup.hp,piplup.getHp());

    }

    @Test
    public void testGetAbilities() {
        ArrayList<String> abilities = new ArrayList<>();
        abilities.add("Bubble Beam");
        abilities.add("Brine");
        abilities.add("Whirlpool");
        abilities.add("Hydro Pump");
        assertEquals(abilities,piplup.getAbilities());
    }

    @Test
    public void testGetEnergies() {
        assertEquals(piplup.energies,piplup.getEnergies());
    }

    @Test
    public void testGetType() {
        assertEquals(piplup.type,piplup.getType());
    }

    @Test
    public void testSetHp() {
        piplup.setHp(20);
        assertEquals(20,piplup.getHp());
    }

    @Test
    public void testIsAlive() {
        assertTrue(piplup.isAlive());
        piplup.setHp(0);
        assertTrue(!piplup.isAlive());
        piplup.setHp(-70);
        assertTrue(!piplup.isAlive());
    }

    @Test
    public void testGetAttacked() {
    }

    @Test
    public void testCheckEnergy() {
    }

    @Test
    public void testGetTypeOfEnergy() {
    }

    @Test
    public void testCountRep() {
    }
}