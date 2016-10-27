package org.funcala.compiler.parser;

import org.funcala.compiler.antlr.FuncalaBaseVisitor;
import org.funcala.compiler.antlr.FuncalaParser;
import org.funcala.compiler.model.StatementBlock;
import org.funcala.compiler.model.statement.Statement;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by feilaoda on 16/10/27.
 */
public class StatementBlockVisitor extends FuncalaBaseVisitor<StatementBlock> {
    @Override
    public StatementBlock visitStatementBlock(FuncalaParser.StatementBlockContext ctx) {
        StatementVisitor visitor = new StatementVisitor();
        List<FuncalaParser.StatementContext> statementContexts = ctx.statement();

        List<Statement> statementList = ctx.statement().stream().map(sctx->sctx.accept(visitor)).collect(Collectors.toList());
        return new StatementBlock(statementList);
    }

}
