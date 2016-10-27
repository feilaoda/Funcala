package org.funcala.compiler.bytecode;

import jdk.internal.org.objectweb.asm.MethodVisitor;
import org.funcala.compiler.model.StatementBlock;
import org.funcala.compiler.model.statement.PrintStatement;
import org.funcala.compiler.model.statement.Statement;

/**
 * Created by feilaoda on 16/10/27.
 */
public class StatementGenerator {

    PrintStatementGenerator printStatementGenerator;

    public StatementGenerator(MethodVisitor methodVisitor) {
        printStatementGenerator = new PrintStatementGenerator(methodVisitor);
    }

    public void generate(Statement statement) {
        System.out.println("not support generate statement");
        if(statement instanceof PrintStatement) {
            generate((PrintStatement)statement);
        }
    }

    public void generate(PrintStatement printStatement) {
        printStatementGenerator.generate(printStatement);
    }
}
