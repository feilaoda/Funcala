package org.funcala.compiler.model;

import org.funcala.compiler.model.statement.Expression;

import java.util.Optional;

/**
 * Created by feilaoda on 16/11/1.
 */
public class Argument {
    private Optional<String> nameOpt;
    private Optional<Expression> expressionOpt;

    public Optional<String> getNameOpt() {
        return nameOpt;
    }

    public void setNameOpt(Optional<String> nameOpt) {
        this.nameOpt = nameOpt;
    }

    public Optional<Expression> getExpressionOpt() {
        return expressionOpt;
    }

    public void setExpressionOpt(Optional<Expression> expressionOpt) {
        this.expressionOpt = expressionOpt;
    }
}
