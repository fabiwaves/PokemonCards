package Cards.Energies;

import Cards.AbstractCard;
import Controller.Game;

/**
 * @author fabiwave
 */

public class PlantEnergy extends AbstractCard implements IEnergy {

    public PlantEnergy() {
        this.setName("Plant Energy");
    }

    public void notifyType(Game game) {
        game.playPlantEnergy(this);
    }
}
