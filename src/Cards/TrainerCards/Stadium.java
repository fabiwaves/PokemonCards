package Cards.TrainerCards;

import Abilities.Effects.AbstractStadiumEffect;
import Controller.Game;
import Abilities.Effects.IEffect;

/**
 * @author fabiwave
 */

public class Stadium extends TrainerCard {

    public AbstractStadiumEffect effect;

    public Stadium(AbstractStadiumEffect effect) {
        this.effect = effect;
        effect.setStadium(this);
    }

    @Override
    public void notifyType(Game game) {
        game.playStadium(this);
    }
}
