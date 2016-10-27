package org.funcala.compiler.model;

import org.funcala.compiler.model.statement.Statement;

import java.util.List;

/**
 * Created by feilaoda on 16/10/27.
 */
public class StatementBlock extends Statement{
    private final List<Statement> statements;

    public StatementBlock(List<Statement> statements) {
        this.statements = statements;
    }

    public List<Statement> getStatements() {
        return statements;
    }
}
