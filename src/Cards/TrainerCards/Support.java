package Cards.TrainerCards;

import Abilities.Effects.IEffect;
import Controller.Game;

/**
 * @author fabiwave
 */

public class Support extends TrainerCard {

    public IEffect effect;

    public Support(IEffect effect) {
        this.effect = effect;
    }

    @Override
    public void notifyType(Game game) {
        game.playSupport(this);
    }
}
