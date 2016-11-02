package org.funcala.compiler.bytecode;

import jdk.internal.org.objectweb.asm.MethodVisitor;
import org.funcala.compiler.model.ClassScope;
import org.funcala.compiler.model.statement.FunctionCall;
import org.funcala.compiler.model.statement.LocalVariableReference;
import org.funcala.compiler.type.Type;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by feilaoda on 16/11/1.
 */
public class LocalVariableReferenceGenerator {
    private final static Logger LOG = LoggerFactory.getLogger(LocalVariableReferenceGenerator.class);
    private final MethodVisitor methodVisitor;
    ExpressionGenerator expressionGenerator;
    ClassScope classScope;

    public LocalVariableReferenceGenerator(ClassScope classScope, ExpressionGenerator expressionGenerator, MethodVisitor methodVisitor) {
        this.classScope = classScope;
        this.expressionGenerator = expressionGenerator;
        this.methodVisitor = methodVisitor;
    }

    public void generate(LocalVariableReference statement)  {
        String varName = statement.getName();
        int index = classScope.getLocalVariableIndex(varName);
        Type type = statement.getType();
        methodVisitor.visitVarInsn(type.getLoadVariableOpcode(), index);
    }
}
