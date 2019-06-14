package Visitors;

import Cards.Pokemon;
import Players.Trainer;

public interface IVisitor {

    /**
     * Visitor of a pokemon
     * @param pokemon object that I want to visit
     */
    public void visitPokemon(Pokemon pokemon);

    /**
     *Visitor of a trainer
     * @param trainer object that I want to visit
     */
    public void visitTrainer(Trainer trainer);

}
