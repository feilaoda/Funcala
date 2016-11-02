package org.funcala.compiler.bytecode;

import jdk.internal.org.objectweb.asm.MethodVisitor;
import org.funcala.compiler.model.ClassScope;
import org.funcala.compiler.model.StatementBlock;
import org.funcala.compiler.model.statement.PrintStatement;
import org.funcala.compiler.model.statement.Statement;

/**
 * Created by feilaoda on 16/10/27.
 */
public class StatementBlockGenerator {

    StatementGenerator statementGenerator;

    public StatementBlockGenerator(ClassScope classScope, MethodVisitor methodVisitor) {
        statementGenerator = new StatementGenerator(classScope, methodVisitor);
    }

    public void generate(StatementBlock statement) {
        statement.getStatements().stream().forEach(stmt -> statementGenerator.generate(stmt));
    }
}
