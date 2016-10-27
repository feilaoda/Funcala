package org.funcala.compiler.model.statement;

import org.funcala.compiler.type.Type;

/**
 * Created by feilaoda on 16/10/27.
 */
public class ValueExpression {
    private String value;
    private Type type;

    public ValueExpression() {

    }
    public ValueExpression(String value, Type type) {
        this.value = value;
        this.type = type;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }
}
