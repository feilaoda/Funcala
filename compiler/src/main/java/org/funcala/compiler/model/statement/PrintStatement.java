package org.funcala.compiler.model.statement;

import org.funcala.compiler.model.StatementBlock;

/**
 * Created by feilaoda on 16/10/27.
 */
public class PrintStatement extends Statement{
    private String expression;

    public PrintStatement(String expression) {
        this.expression = expression;
    }

    public String getExpression() {
        return expression;
    }

    public void setExpression(String expression) {
        this.expression = expression;
    }
}
