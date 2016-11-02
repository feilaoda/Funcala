package org.funcala.compiler.bytecode;

import jdk.internal.org.objectweb.asm.MethodVisitor;
import jdk.internal.org.objectweb.asm.Opcodes;
import org.funcala.compiler.model.statement.Expression;
import org.funcala.compiler.model.statement.PrintStatement;
import org.funcala.compiler.type.BasicType;
import org.funcala.compiler.type.ClassType;
import org.funcala.compiler.type.Type;
import org.funcala.compiler.type.TypeResolver;

/**
 * Created by feilaoda on 16/10/27.
 */
public class PrintStatementGenerator {
    MethodVisitor methodVisitor;
    ExpressionGenerator expressionGenerator;

    public PrintStatementGenerator(ExpressionGenerator expressionGenerator, MethodVisitor methodVisitor) {
        this.expressionGenerator = expressionGenerator;
        this.methodVisitor = methodVisitor;
    }

    public void generate(PrintStatement printStatement) {
        Expression expression = printStatement.getExpression();
        methodVisitor.visitFieldInsn(Opcodes.GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
        expressionGenerator.generate(expression);

        Type type = expression.getType();
        String descriptor = "(" + type.getDescriptor() + ")V";
        ClassType owner = new ClassType("java.io.PrintStream");
        String fieldDescriptor = owner.getDescriptor();
        methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/io/PrintStream", "println", descriptor, false);
    }




}
