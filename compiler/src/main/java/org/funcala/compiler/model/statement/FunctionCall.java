package org.funcala.compiler.model.statement;

import org.funcala.compiler.model.Argument;
import org.funcala.compiler.type.Type;

import java.util.List;

/**
 * Created by feilaoda on 16/11/1.
 */
public class FunctionCall extends CallExpression{
    private final Expression caller;
    private final List<Argument> arguments;
    private final Type type;
    private final String functionName;

    public FunctionCall(String functionName, Expression expression, List<Argument> arguments) {
        this.functionName = functionName;
        caller = expression;
        this.type = expression.getType();
        this.arguments = arguments;
    }

    public Expression getCaller() {
        return caller;
    }

    public List<Argument> getArguments() {
        return arguments;
    }

    public Type getType() {
        return type;
    }

    public String getFunctionName() {
        return functionName;
    }
}
