package org.funcala.compiler.model.statement;

import org.funcala.compiler.model.Argument;

import java.util.List;

/**
 * Created by feilaoda on 16/11/1.
 */
public abstract class CallExpression extends Expression{
    public abstract List<Argument> getArguments();
}
