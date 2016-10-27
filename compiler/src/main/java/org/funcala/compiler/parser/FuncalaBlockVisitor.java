package org.funcala.compiler.parser;

import org.funcala.compiler.antlr.FuncalaBaseVisitor;
import org.funcala.compiler.antlr.FuncalaParser;
import org.funcala.compiler.model.ClassBlock;
import org.funcala.compiler.model.FuncalaBlock;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by feilaoda on 16/10/26.
 */
public class FuncalaBlockVisitor extends FuncalaBaseVisitor<FuncalaBlock> {
    @Override
    public FuncalaBlock visitFuncalaBlock(FuncalaParser.FuncalaBlockContext ctx)
    {
        ClassVisitor classVisitor = new ClassVisitor();
        List<ClassBlock> classBlockList = ctx.classBlock().stream().map(classCtx->classCtx.accept(new ClassVisitor())).collect(Collectors.toList());
        return new FuncalaBlock(classBlockList);
    }
}
