package org.funcala.compiler.bytecode;

import jdk.internal.org.objectweb.asm.MethodVisitor;
import org.funcala.compiler.model.ClassScope;
import org.funcala.compiler.model.statement.Expression;
import org.funcala.compiler.model.statement.FunctionCall;
import org.funcala.compiler.model.statement.PrintStatement;
import org.funcala.compiler.model.statement.Statement;

/**
 * Created by feilaoda on 16/10/27.
 */
public class StatementGenerator {

    PrintStatementGenerator printStatementGenerator;


    ExpressionGenerator expressionGenerator;

    public StatementGenerator(ClassScope classScope,  MethodVisitor methodVisitor) {
        expressionGenerator = new ExpressionGenerator(classScope, methodVisitor);
        printStatementGenerator = new PrintStatementGenerator(expressionGenerator, methodVisitor);

    }

    public void generate(Statement statement) {

        if (statement instanceof PrintStatement) {
            generate((PrintStatement) statement);
        } else if (statement instanceof Expression) {
            generate((Expression) statement);
        } else {
            System.out.println("not support generate statement: " + statement.getClass());
        }
    }

    public void generate(PrintStatement statement) {
        printStatementGenerator.generate(statement);
    }

    public void generate(Expression statement) {
        expressionGenerator.generate(statement);
    }
}
