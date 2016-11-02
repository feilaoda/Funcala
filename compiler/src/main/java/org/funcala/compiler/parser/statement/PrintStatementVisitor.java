package org.funcala.compiler.parser.statement;

import org.funcala.compiler.antlr.FuncalaBaseVisitor;
import org.funcala.compiler.antlr.FuncalaParser;
import org.funcala.compiler.model.ClassScope;
import org.funcala.compiler.model.statement.Expression;
import org.funcala.compiler.model.statement.PrintStatement;
import org.funcala.compiler.model.statement.ValueExpression;
import org.funcala.compiler.type.TypeResolver;

/**
 * Created by feilaoda on 16/10/27.
 */
public class PrintStatementVisitor extends FuncalaBaseVisitor<PrintStatement> {

    private ClassScope classScope;

    public PrintStatementVisitor(ClassScope classScope) {
        this.classScope = classScope;
    }

    @Override
    public PrintStatement visitPrintStatement(FuncalaParser.PrintStatementContext ctx) {
        FuncalaParser.ExpressionContext exprCtx = ctx.expression();
        Expression expression = exprCtx.accept(new ExpressionVisitor(classScope));
        return new PrintStatement(expression);
    }

}
