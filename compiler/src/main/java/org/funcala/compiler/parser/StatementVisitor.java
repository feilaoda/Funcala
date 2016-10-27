package org.funcala.compiler.parser;

import org.funcala.compiler.antlr.FuncalaBaseVisitor;
import org.funcala.compiler.antlr.FuncalaParser;
import org.funcala.compiler.model.statement.Statement;
import org.funcala.compiler.parser.statement.PrintStatementVisitor;

/**
 * Created by feilaoda on 16/10/27.
 */
public class StatementVisitor extends FuncalaBaseVisitor<Statement> {

    StatementBlockVisitor statementBlockVisitor;
    PrintStatementVisitor printStatementVisitor;

    public StatementVisitor() {
        statementBlockVisitor = new StatementBlockVisitor();
        printStatementVisitor = new PrintStatementVisitor();
    }

    @Override
    public Statement visitStatementBlock(FuncalaParser.StatementBlockContext ctx) {
        System.out.println("visit statment block");
        return statementBlockVisitor.visitStatementBlock(ctx);
    }


    @Override
    public Statement visitStatement(FuncalaParser.StatementContext ctx) {
        System.out.println("visit statment");
        return visitChildren(ctx);
    }


    @Override
    public Statement visitPrintStatement(FuncalaParser.PrintStatementContext ctx) {
        System.out.println("visit print statment");
        return printStatementVisitor.visitPrintStatement(ctx);
    }

}
