package org.funcala.compiler.parser;

import org.funcala.compiler.antlr.FuncalaBaseVisitor;
import org.funcala.compiler.antlr.FuncalaParser;
import org.funcala.compiler.model.FunctionBlock;
import org.funcala.compiler.model.Parameter;
import org.funcala.compiler.model.StatementBlock;
import org.funcala.compiler.type.BasicType;
import org.funcala.compiler.type.Type;
import org.funcala.compiler.util.TypeResolver;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by feilaoda on 16/10/26.
 */
public class FunctionVisitor extends FuncalaBaseVisitor<FunctionBlock> {
    @Override
    public FunctionBlock visitFunctionBlock(FuncalaParser.FunctionBlockContext ctx) {
        String name = ctx.functionName().NAME().getText();
        Type type ;
        if(ctx.functionReturnType() == null) {
            type = BasicType.VOID;
        }else {
            type = TypeResolver.getFromTypeContext(ctx.functionReturnType().type());
        }

        List<Parameter> parameterList = new ArrayList<>();

        if(ctx.parametersBlock() != null) {
            ctx.parametersBlock().parameter().forEach(parameterContext -> {
                parameterList.add(new Parameter(parameterContext.NAME().getText(), TypeResolver.getFromTypeContext(parameterContext.type())));
            });
        }

        FuncalaParser.StatementBlockContext statementBlockContext = ctx.functionBody().statementBlock();

        FunctionBlock functionBlock = new FunctionBlock(name, parameterList, type);


        if(statementBlockContext != null) {
            StatementBlockVisitor statementBlockVisitor = new StatementBlockVisitor();
            StatementBlock statementBlock = statementBlockContext.accept(statementBlockVisitor);
            functionBlock.setStatement(statementBlock);
        }


        return functionBlock;
    }
}
