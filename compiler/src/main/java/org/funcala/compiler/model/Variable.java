package org.funcala.compiler.model;

import org.funcala.compiler.type.Type;

/**
 * Created by feilaoda on 16/11/1.
 */
public abstract class Variable {
    public abstract Type getType();
    public abstract String getName();
}
