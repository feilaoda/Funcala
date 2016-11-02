package org.funcala.compiler.parser;

import org.funcala.compiler.antlr.FuncalaBaseVisitor;
import org.funcala.compiler.antlr.FuncalaParser;
import org.funcala.compiler.model.ClassBlock;
import org.funcala.compiler.model.ClassScope;
import org.funcala.compiler.model.FunctionBlock;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by feilaoda on 16/10/26.
 */
public class ClassVisitor extends FuncalaBaseVisitor<ClassBlock> {
    ClassScope classScope;

    public ClassVisitor() {
    }


    @Override
    public ClassBlock visitClassBlock(FuncalaParser.ClassBlockContext ctx) {

//        MetaData metaData = new MetaData(ctx.className().getText(),"java.lang.Object");

        classScope = new ClassScope(ctx.className().getText(),"java.lang.Object");

        List<FuncalaParser.ClassMemberContext> memberContexts = ctx.classBody().classMember();

        List<FunctionBlock> functionBlockList = new ArrayList<>();
        memberContexts.
                stream().forEach(method -> { if(method.functionBlock()!=null) { FunctionBlock block = method.functionBlock().accept(new FunctionVisitor(classScope)); functionBlockList.add(block); }}
            );

        ClassBlock classBlock = new ClassBlock(ctx.className().getText(), functionBlockList);
        return classBlock;
    }


}
