package org.funcala.compiler;

import org.apache.commons.lang3.StringUtils;
import org.funcala.compiler.bytecode.FuncalaGenerator;
import org.funcala.compiler.model.FuncalaBlock;

import java.io.File;
import java.io.IOException;

/**
 * Created by feilaoda on 16/10/24.
 */
public class Compiler {


    public static void main(String[] args) throws Exception{

        final File file = new File("example/Hello.fc");
        String fileName = file.getName();
        String fileAbsolutePath = file.getAbsolutePath();
        String className = StringUtils.remove(fileName, ".fc");
        FuncalaBlock funcalaBlock = new SyntaxTreeTraverser().walk(fileAbsolutePath);
        saveBytecodeToClassFile(funcalaBlock);
    }

    private static void saveBytecodeToClassFile(FuncalaBlock funcalaBlock) throws IOException {
        FuncalaGenerator bytecodeGenerator = new FuncalaGenerator();
        bytecodeGenerator.generate(funcalaBlock);

    }
}
