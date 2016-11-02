package org.funcala.compiler.model;

import org.funcala.compiler.type.Type;

/**
 * Created by feilaoda on 16/11/1.
 */
public class LocalVariable extends Variable{
    private final Type type;
    private final String name;

    public LocalVariable(String name, Type type) {
        this.type = type;
        this.name = name;
    }

    @Override
    public Type getType() {
        return type;
    }

    @Override
    public String getName() {
        return name;
    }
}
