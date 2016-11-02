package org.funcala.compiler.bytecode;

import jdk.internal.org.objectweb.asm.MethodVisitor;
import org.funcala.compiler.model.ClassScope;
import org.funcala.compiler.model.statement.Expression;
import org.funcala.compiler.model.statement.FunctionCall;
import org.funcala.compiler.model.statement.LocalVariableReference;
import org.funcala.compiler.model.statement.ValueExpression;
import org.funcala.compiler.type.Type;
import org.funcala.compiler.type.TypeResolver;

/**
 * Created by feilaoda on 16/10/27.
 */
public class ValueExpressionGenerator {

    private MethodVisitor methodVisitor;

    public ValueExpressionGenerator(MethodVisitor methodVisitor) {
        this.methodVisitor = methodVisitor;
    }

    public void generate(ValueExpression expression) {
        Type type = expression.getType();
        String stringValue = expression.getValue();
        Object transformedValue = TypeResolver.getValueFromString(stringValue, type);
        methodVisitor.visitLdcInsn(transformedValue);
    }

}
