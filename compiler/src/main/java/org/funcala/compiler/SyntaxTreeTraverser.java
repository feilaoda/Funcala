package org.funcala.compiler;

import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.funcala.compiler.antlr.*;
import org.funcala.compiler.model.FuncalaBlock;
import org.funcala.compiler.parser.FuncalaBlockVisitor;

import java.io.IOException;

/**
 * Created by feilaoda on 16/10/24.
 */
public class SyntaxTreeTraverser {
    public FuncalaBlock walk(String fileAbsolutePath) throws IOException {
        CharStream charStream = new ANTLRFileStream(fileAbsolutePath);
        FuncalaLexer lexer = new FuncalaLexer(charStream);
        CommonTokenStream tokenStream = new CommonTokenStream(lexer);
        FuncalaParser parser = new FuncalaParser(tokenStream);
//        FuncalaTreeListener listener = new FuncalaTreeListener();
//        parser.addParseListener(listener);
//        parser.funcalaBlock();

        FuncalaBlockVisitor funcalaBlockVisitor = new FuncalaBlockVisitor();
        FuncalaBlock funcalaBlock = parser.funcalaBlock().accept(funcalaBlockVisitor);
//        System.out.print(funcalaBlock);
        return funcalaBlock;
    }
}