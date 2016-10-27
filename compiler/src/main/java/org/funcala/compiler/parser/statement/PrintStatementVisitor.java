package org.funcala.compiler.parser.statement;

import org.funcala.compiler.antlr.FuncalaBaseVisitor;
import org.funcala.compiler.antlr.FuncalaParser;
import org.funcala.compiler.model.statement.PrintStatement;

/**
 * Created by feilaoda on 16/10/27.
 */
public class PrintStatementVisitor extends FuncalaBaseVisitor<PrintStatement> {
    @Override
    public PrintStatement visitPrintStatement(FuncalaParser.PrintStatementContext ctx) {
        if(ctx.NAME() != null) {
            return new PrintStatement(ctx.NAME().getText());
        }else if(ctx.STRING() != null) {
            return new PrintStatement(ctx.STRING().getText());
        }else {
            return new PrintStatement("");
        }
    }

}
