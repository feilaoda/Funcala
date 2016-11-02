package org.funcala.compiler.bytecode;

import jdk.internal.org.objectweb.asm.MethodVisitor;
import org.funcala.compiler.model.ClassScope;
import org.funcala.compiler.model.statement.Expression;
import org.funcala.compiler.model.statement.FunctionCall;
import org.funcala.compiler.model.statement.LocalVariableReference;
import org.funcala.compiler.model.statement.ValueExpression;

/**
 * Created by feilaoda on 16/10/27.
 */
public class ExpressionGenerator {

    FunctionCallGenerator functionCallGenerator;
    LocalVariableReferenceGenerator localVariableReferenceGenerator;
    ValueExpressionGenerator valueExpressionGenerator;

    public ExpressionGenerator(ClassScope classScope,  MethodVisitor methodVisitor) {
        functionCallGenerator = new FunctionCallGenerator(classScope, this, methodVisitor);
        localVariableReferenceGenerator = new LocalVariableReferenceGenerator(classScope, this, methodVisitor);

        valueExpressionGenerator = new ValueExpressionGenerator(methodVisitor);
    }

    public void generate(Expression expression) {
        System.out.println("not support generate statement");
        if(expression instanceof FunctionCall) {
            generate((FunctionCall)expression);
        }else if(expression instanceof LocalVariableReference) {
            generate((LocalVariableReference)expression);
        }else if(expression instanceof ValueExpression) {
            generate((ValueExpression)expression);
        }
    }

    public void generate(FunctionCall statement) {
        functionCallGenerator.generate(statement);
    }

    public void generate(LocalVariableReference statement) {
        localVariableReferenceGenerator.generate(statement);
    }

    public void generate(ValueExpression statement) {
        valueExpressionGenerator.generate(statement);
    }
}
