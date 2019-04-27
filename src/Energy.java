/**
 * @author Fabiwave
 */
public class Energy implements Card {

    private String name;
    private String type;

    public Energy(String name, String type) {
        this.name = name;
        this.type = type;
    }

    /**
     * Gives the name of the energy
     *
     * @return the name of this energy
     */
    public String getName() {
        return this.name;
    }

    /**
     * Gives the type of the energy
     *
     * @return the type of the energy
     */
    public String getType() {
        return this.type;
    }

}
