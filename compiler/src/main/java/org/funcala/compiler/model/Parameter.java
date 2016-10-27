package org.funcala.compiler.model;

import org.funcala.compiler.type.Type;

/**
 * Created by feilaoda on 16/10/26.
 */
public class Parameter {
    private final String name;
    private final Type type;

    public Parameter(String name, Type type) {
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public Type getType() {
        return type;
    }
}
