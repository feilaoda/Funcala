package org.funcala.compiler.model.statement;

import org.funcala.compiler.type.Type;

/**
 * Created by feilaoda on 16/11/1.
 */
public abstract class Expression extends Statement{
    public abstract Type getType();
}
