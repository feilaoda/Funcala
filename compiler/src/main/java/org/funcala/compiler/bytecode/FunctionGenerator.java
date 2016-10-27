package org.funcala.compiler.bytecode;

import jdk.internal.org.objectweb.asm.ClassWriter;
import jdk.internal.org.objectweb.asm.MethodVisitor;
import jdk.internal.org.objectweb.asm.Opcodes;
import org.funcala.compiler.model.FunctionBlock;
import org.funcala.compiler.model.Parameter;
import org.funcala.compiler.type.Type;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by feilaoda on 16/10/26.
 */
public class FunctionGenerator {
    private final static Logger LOGGER = LoggerFactory.getLogger(FunctionGenerator.class);
    public static final String MAIN_FUN_NAME = "main";
    private final ClassWriter classWriter;

    public FunctionGenerator(ClassWriter classWriter) {
        this.classWriter = classWriter;
    }

    public void generate(FunctionBlock function)  {
        String name = function.getName();
        boolean isMain = name.equals("main");
        String description = getMethodDescriptor(function);
//        Block block = (Block) function.getRootStatement();
//        Scope scope = block.getScope();
        int access = Opcodes.ACC_PUBLIC + (isMain ? Opcodes.ACC_STATIC : 0);
        if(isMain) {
            description = "([Ljava/lang/String;)V";
        }
        MethodVisitor mv = classWriter.visitMethod(access, name, description, null, null);
        mv.visitCode();
        StatementBlockGenerator statementBlockGenerator = new StatementBlockGenerator(mv);
        statementBlockGenerator.generate(function.getStatement());
//        block.accept(statementScopeGenrator);
//        appendReturnIfNotExists(function, block,statementScopeGenrator);
//        if(function.getReturnType())
        mv.visitInsn(Opcodes.RETURN);
        mv.visitMaxs(-1,-1);
        mv.visitEnd();
    }


    public static String getMethodDescriptor(FunctionBlock function) {
        List<Parameter> parameters = function.getParameters();
        Type returnType = function.getReturnType();

        String parametersDescriptor = parameters.stream()
                .map(parameter -> parameter.getType().getDescriptor())
                .collect(Collectors.joining("", "(", ")"));
        return parametersDescriptor + returnType.getDescriptor();
    }

}
