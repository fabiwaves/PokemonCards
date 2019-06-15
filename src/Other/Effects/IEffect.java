package Other.Effects;

import Visitors.IVisitor;

public interface IEffect extends IVisitor {

    void executeBefore();
    void executeAfter();

}
