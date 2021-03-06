package net.sf.jsqlparser.expression.fuzzy;

import net.sf.jsqlparser.expression.Expression;
import net.sf.jsqlparser.expression.ExpressionVisitor;

public class FuzzyTrapezoid implements Expression {

    private Expression exp1;
    private Expression exp2;
    private Expression exp3;
    private Expression exp4;

    public FuzzyTrapezoid(Expression exp1, Expression exp2, Expression exp3, Expression exp4) {
        this.exp1 = exp1;
        this.exp2 = exp2;
        this.exp3 = exp3;
        this.exp4 = exp4;
    }

    // Ugh, esto al menos lo resuelve rápidamente.
    public Expression getExp1() {
        return this.exp1;
    }

    public Expression getExp2() {
        return this.exp2;
    }

    public Expression getExp3() {
        return this.exp3;
    }

    public Expression getExp4() {
        return this.exp4;
    }
    
    public void accept(ExpressionVisitor expressionVisitor) throws Exception {
        expressionVisitor.visit(this);
    }
}