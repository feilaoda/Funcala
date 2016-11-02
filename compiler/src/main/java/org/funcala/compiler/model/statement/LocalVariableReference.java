package org.funcala.compiler.model.statement;

import org.funcala.compiler.model.LocalVariable;
import org.funcala.compiler.type.Type;

/**
 * Created by feilaoda on 16/11/1.
 */
public class LocalVariableReference extends Reference{
    private LocalVariable localVariable;
    public LocalVariableReference(LocalVariable variable) {
        localVariable = variable;
    }

    @Override
    public String getName() {
        return localVariable.getName();
    }

    @Override
    public Type getType() {
        return localVariable.getType();
    }
}
