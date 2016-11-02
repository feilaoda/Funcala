package org.funcala.compiler.parser.statement;

import org.funcala.compiler.antlr.FuncalaBaseVisitor;
import org.funcala.compiler.antlr.FuncalaParser;
import org.funcala.compiler.model.ClassScope;
import org.funcala.compiler.model.statement.Expression;
import org.funcala.compiler.model.statement.PrintStatement;
import org.funcala.compiler.model.statement.ValueExpression;
import org.funcala.compiler.parser.StatementVisitor;
import org.funcala.compiler.type.TypeResolver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by feilaoda on 16/10/27.
 */
public class ValueExpressionVisitor extends FuncalaBaseVisitor<ValueExpression> {
    private static final Logger LOG = LoggerFactory.getLogger(ValueExpressionVisitor.class);

    private ClassScope classScope;

    public ValueExpressionVisitor(ClassScope classScope) {
        this.classScope = classScope;
    }

    @Override
    public ValueExpression visitValueExpression(FuncalaParser.ValueExpressionContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public ValueExpression visitValue(FuncalaParser.ValueContext ctx) {
        LOG.debug("visit value");

        ValueExpression valueExpression = new ValueExpression();
        String value = ctx.getText();
        if (ctx.STRING() != null) {
            valueExpression.setValue(value);
            valueExpression.setType(TypeResolver.getFromValue("String"));

        } else if (ctx.NUMBER() != null) {
            valueExpression.setValue(value);
            valueExpression.setType(TypeResolver.getFromValue("Int"));
        } else {
            System.out.println("unknown: " + ctx.getText());
        }
        return valueExpression;
    }

}
