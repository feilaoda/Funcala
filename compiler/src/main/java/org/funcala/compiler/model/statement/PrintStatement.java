package org.funcala.compiler.model.statement;

import org.funcala.compiler.model.StatementBlock;

/**
 * Created by feilaoda on 16/10/27.
 */
public class PrintStatement extends Statement{
    private Expression expression;

    public PrintStatement(Expression expression) {
        this.expression = expression;
    }

    public Expression getExpression() {
        return expression;
    }

    public void setExpression(Expression expression) {
        this.expression = expression;
    }
}
