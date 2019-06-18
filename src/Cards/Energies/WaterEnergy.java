package Cards.Energies;

import Cards.AbstractCard;
import Controller.Game;

/**
 * @author fabiwave
 */

public class WaterEnergy extends AbstractCard implements IEnergy {

    public WaterEnergy() {
        this.setName("Water Energy");
    }

    public void notifyType(Game game) {
        game.playWaterEnergy(this);
    }
}
