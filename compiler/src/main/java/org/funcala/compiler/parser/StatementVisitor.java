package org.funcala.compiler.parser;

import org.funcala.compiler.antlr.FuncalaBaseVisitor;
import org.funcala.compiler.antlr.FuncalaParser;
import org.funcala.compiler.model.ClassScope;
import org.funcala.compiler.model.statement.Expression;
import org.funcala.compiler.model.statement.Statement;
import org.funcala.compiler.parser.statement.ExpressionVisitor;
import org.funcala.compiler.parser.statement.PrintStatementVisitor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by feilaoda on 16/10/27.
 */
public class StatementVisitor extends FuncalaBaseVisitor<Statement> {

    private static final Logger LOG = LoggerFactory.getLogger(StatementVisitor.class);

    private StatementBlockVisitor statementBlockVisitor;
    private PrintStatementVisitor printStatementVisitor;
    private ExpressionVisitor expressionVisitor;
    private ClassScope classScope;


    public StatementVisitor(ClassScope classScope) {
        statementBlockVisitor = new StatementBlockVisitor(classScope);
        printStatementVisitor = new PrintStatementVisitor(classScope);
        expressionVisitor = new ExpressionVisitor(classScope);
        this.classScope = classScope;
    }

    @Override
    public Statement visitStatementBlock(FuncalaParser.StatementBlockContext ctx) {
        System.out.println("visit statment block");
        return statementBlockVisitor.visitStatementBlock(ctx);
    }


    @Override
    public Statement visitStatement(FuncalaParser.StatementContext ctx) {
        LOG.debug("visit statment");
        return visitChildren(ctx);
    }


    @Override
    public Statement visitPrintStatement(FuncalaParser.PrintStatementContext ctx) {
        LOG.debug("visit print statment");
        return printStatementVisitor.visitPrintStatement(ctx);
    }

    @Override
    public Expression visitFunctionCallExpression(FuncalaParser.FunctionCallExpressionContext ctx) {
        LOG.debug("visit function call expression");
        return expressionVisitor.visitFunctionCallExpression(ctx);
    }


}
