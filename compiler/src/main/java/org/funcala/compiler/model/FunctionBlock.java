package org.funcala.compiler.model;

import org.funcala.compiler.type.Type;

import java.util.List;

/**
 * Created by feilaoda on 16/10/26.
 */
public class FunctionBlock {
    private ClassScope classScope;
    private String name;
    private List<Parameter> parameters;
    private Type returnType;

    private StatementBlock statement;

    public FunctionBlock(ClassScope classScope, String name, List<Parameter> parameters,  Type returnType) {
        this.classScope = classScope;
        this.name = name;
        this.parameters = parameters;
        this.returnType = returnType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Parameter> getParameters() {
        return parameters;
    }

    public void setParameters(List<Parameter> parameters) {
        this.parameters = parameters;
    }

    public Type getReturnType() {
        return returnType;
    }

    public void setReturnType(Type returnType) {
        this.returnType = returnType;
    }

    public StatementBlock getStatement() {
        return statement;
    }

    public void setStatement(StatementBlock statement) {
        this.statement = statement;
    }

    public ClassScope getClassScope() {
        return classScope;
    }

    public void setClassScope(ClassScope classScope) {
        this.classScope = classScope;
    }
}
