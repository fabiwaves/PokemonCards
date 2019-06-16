package Visitors;

import Cards.IPokemon;
import Players.Trainer;

public interface IVisitor {

    /**
     * Visitor of a pokemon
     *
     * @param pokemon object that I want to visit
     */
    public void visitPokemon(IPokemon pokemon);

    /**
     * Visitor of a trainer
     *
     * @param trainer object that I want to visit
     */
    public void visitTrainer(Trainer trainer);

}
