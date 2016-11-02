package org.funcala.compiler.parser.statement;

import org.funcala.compiler.antlr.FuncalaBaseVisitor;
import org.funcala.compiler.antlr.FuncalaParser;
import org.funcala.compiler.model.ClassScope;
import org.funcala.compiler.model.statement.Expression;
import org.funcala.compiler.model.statement.ValueExpression;
import org.funcala.compiler.parser.StatementVisitor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by feilaoda on 16/10/27.
 */
public class ExpressionVisitor extends FuncalaBaseVisitor<Expression> {
    private static final Logger LOG = LoggerFactory.getLogger(ExpressionVisitor.class);

    private final FunctionCallVisitor functionCallVisitor;
    private final ValueExpressionVisitor valueExpressionVisitor;
    private final VariableReferenceVisitor variableReferenceVisitor;
    private ClassScope classScope;

    public ExpressionVisitor(ClassScope classScope) {
        this.classScope = classScope;
        functionCallVisitor = new FunctionCallVisitor(classScope, this);
        valueExpressionVisitor = new ValueExpressionVisitor(classScope);
        variableReferenceVisitor = new VariableReferenceVisitor(classScope);
    }


    @Override
    public Expression visitFunctionCallExpression(FuncalaParser.FunctionCallExpressionContext ctx) {
        LOG.debug("visit function call expression");
        return functionCallVisitor.visitFunctionCallExpression(ctx);
    }

    @Override
    public Expression visitValueExpression(FuncalaParser.ValueExpressionContext ctx) {
        LOG.debug("visit value expression");
        return valueExpressionVisitor.visitValueExpression(ctx);
    }

    @Override
    public Expression visitVarReferenceExpression(FuncalaParser.VarReferenceExpressionContext ctx) {
        LOG.debug("visit value expression");
        return variableReferenceVisitor.visitVarReferenceExpression(ctx);
    }


}
