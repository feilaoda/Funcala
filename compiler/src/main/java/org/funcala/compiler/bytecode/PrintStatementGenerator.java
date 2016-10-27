package org.funcala.compiler.bytecode;

import com.sun.org.apache.xpath.internal.compiler.OpCodes;
import jdk.internal.org.objectweb.asm.MethodVisitor;
import jdk.internal.org.objectweb.asm.Opcodes;
import org.apache.commons.lang3.StringUtils;
import org.funcala.compiler.model.statement.PrintStatement;
import org.funcala.compiler.type.BasicType;
import org.funcala.compiler.type.ClassType;
import org.funcala.compiler.type.Type;
import org.funcala.compiler.util.TypeResolver;

/**
 * Created by feilaoda on 16/10/27.
 */
public class PrintStatementGenerator {
    MethodVisitor methodVisitor;

    public PrintStatementGenerator(MethodVisitor methodVisitor) {
        this.methodVisitor = methodVisitor;
    }

    public void generate(PrintStatement printStatement) {
        methodVisitor.visitFieldInsn(Opcodes.GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
        Type type = BasicType.STRING;
        String descriptor = "(" + type.getDescriptor() + ")V";
        ClassType owner = new ClassType("java.io.PrintStream");
        String fieldDescriptor = owner.getDescriptor();
//        methodVisitor.visitVarInsn(Opcodes.ALOAD, id);

        Object val = TypeResolver.getValueFromString(printStatement.getExpression().getValue(), printStatement.getExpression().getType());

        methodVisitor.visitLdcInsn(val);
        methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/io/PrintStream", "println", descriptor, false);
    }




}
