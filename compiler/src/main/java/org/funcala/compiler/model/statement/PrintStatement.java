package org.funcala.compiler.model.statement;

import org.funcala.compiler.model.StatementBlock;

/**
 * Created by feilaoda on 16/10/27.
 */
public class PrintStatement extends Statement{
    private ValueExpression expression;

    public PrintStatement(ValueExpression expression) {
        this.expression = expression;
    }

    public ValueExpression getExpression() {
        return expression;
    }

    public void setExpression(ValueExpression expression) {
        this.expression = expression;
    }
}
