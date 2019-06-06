import Types.Water;
import Cartas.IEnergy;
import Cartas.Pokemon;
import org.junit.Before;

import java.util.ArrayList;

public class PokemonTest {

    private Pokemon piplup;
    private ArrayList<String> abilities;
    private ArrayList<IEnergy> energies;
    private Water water;

    @Before
    public void setUp() {
        /*//Array for the abilities
        abilities = new ArrayList<>();
        abilities.add("Bubble Beam");
        abilities.add("Brine");
        abilities.add("Whirlpool");
        abilities.add("Hydro Pump");
        //Array for the energies
        energies = new ArrayList<>();
        IEnergy energy = new IEnergy("name","type");
        energies.add(energy);
        //Initialization of type
        water = new Water();
        //Initialization of piplup
        piplup = new Pokemon("Piplup", 393, 70, abilities, energies, water);

    }

    @Test
    public void testGetName() {
        assertEquals("Piplup", piplup.getName());
        assertEquals(piplup.getName(), piplup.getName());
    }

    @Test
    public void testGetId() {
        assertEquals(393,piplup.getId());
    }

    @Test
    public void testGetHp() {
        assertEquals(70,piplup.getHp());
    }

    @Test
    public void testGetAbilities() {
        assertEquals(abilities,piplup.getAttacks());
    }

    @Test
    public void testGetEnergies() {
        assertEquals(energies,piplup.getEnergies());
    }

    @Test
    public void testGetType() {
        assertEquals(water, piplup.getType());
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
    */
}}