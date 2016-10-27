package org.funcala.compiler.parser.statement;

import org.funcala.compiler.antlr.FuncalaBaseVisitor;
import org.funcala.compiler.antlr.FuncalaParser;
import org.funcala.compiler.model.statement.PrintStatement;
import org.funcala.compiler.model.statement.ValueExpression;
import org.funcala.compiler.util.TypeResolver;

/**
 * Created by feilaoda on 16/10/27.
 */
public class PrintStatementVisitor extends FuncalaBaseVisitor<PrintStatement> {
    @Override
    public PrintStatement visitPrintStatement(FuncalaParser.PrintStatementContext ctx) {
        ValueExpression valueExpression = new ValueExpression();
        if(ctx.NAME() != null) {
//            return new PrintStatement(ctx.NAME().getText());
        }else if(ctx.STRING() != null) {
            valueExpression.setValue(ctx.STRING().getText());
            valueExpression.setType(TypeResolver.getFromValue("String"));

        }else if(ctx.NUMBER() != null){
            valueExpression.setValue(ctx.NUMBER().getText());
            valueExpression.setType(TypeResolver.getFromValue("Integer"));
        } else {
            System.out.println("unknown: "+ ctx.getText());
        }
        return new PrintStatement(valueExpression);
    }

}
