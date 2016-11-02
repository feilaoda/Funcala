package org.funcala.compiler.parser;

import org.funcala.compiler.antlr.FuncalaBaseVisitor;
import org.funcala.compiler.antlr.FuncalaParser;
import org.funcala.compiler.model.*;
import org.funcala.compiler.type.BasicType;
import org.funcala.compiler.type.Type;
import org.funcala.compiler.type.TypeResolver;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by feilaoda on 16/10/26.
 */
public class FunctionVisitor extends FuncalaBaseVisitor<FunctionBlock> {

    private ClassScope classScope;
    public FunctionVisitor(ClassScope classScope) {
        this.classScope = new ClassScope(classScope);
    }

    @Override
    public FunctionBlock visitFunctionBlock(FuncalaParser.FunctionBlockContext ctx) {

        classScope.addLocalVariable(new LocalVariable("this", classScope.getClassType()));
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

        parameterList.stream().forEach(p->classScope.addLocalVariable(new LocalVariable(p.getName(), p.getType())));

        FuncalaParser.StatementBlockContext statementBlockContext = ctx.functionBody().statementBlock();

        FunctionBlock functionBlock = new FunctionBlock(classScope, name, parameterList, type);


        if(statementBlockContext != null) {
            StatementBlockVisitor statementBlockVisitor = new StatementBlockVisitor(classScope);
            StatementBlock statementBlock = statementBlockContext.accept(statementBlockVisitor);
            functionBlock.setStatement(statementBlock);
        }


        return functionBlock;
    }
}
