package org.funcala.compiler;

import org.funcala.compiler.antlr.FuncalaBaseListener;
import org.funcala.compiler.antlr.FuncalaParser;

/**
 * Created by feilaoda on 16/10/26.
 */
public class FuncalaTreeListener extends FuncalaBaseListener{

    @Override public void exitClassBlock(FuncalaParser.ClassBlockContext ctx) {
        ctx.classBody().classMember().stream().forEach(member-> {System.out.println(member.functionBlock()); });
    }

    @Override public void exitFunctionBlock(FuncalaParser.FunctionBlockContext ctx) {
        System.out.println("functionName: "+ctx.functionName().NAME().getSymbol().getText());
        System.out.println("modifiers:" + ctx.modifiers());
        System.out.println("returnType:"+ (ctx.functionReturnType()==null? "":ctx.functionReturnType().getText()));
        System.out.println(ctx.parent.isEmpty());
    }
}
