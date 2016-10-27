package org.funcala.compiler.bytecode;

import jdk.internal.org.objectweb.asm.ClassWriter;
import jdk.internal.org.objectweb.asm.Opcodes;
import org.funcala.compiler.model.ClassBlock;
import org.funcala.compiler.model.FunctionBlock;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * Created by feilaoda on 16/10/26.
 */
public class ClassGenerator {
    private final static Logger LOGGER = LoggerFactory.getLogger(ClassGenerator.class);

    private static final int CLASS_VERSION = 52;
    private final ClassWriter classWriter;

    public ClassGenerator() {
        classWriter = new ClassWriter(ClassWriter.COMPUTE_FRAMES + ClassWriter.COMPUTE_MAXS);
    }

    public byte[] generate(ClassBlock definition)  {

        String name = definition.getName();
        classWriter.visit(CLASS_VERSION, Opcodes.ACC_PUBLIC + Opcodes.ACC_SUPER,name,null,"java/lang/Object",null);
        List<FunctionBlock> methods = definition.getFunctionBlockList();
//        Collection<Field> fields = classDeclaration.getFields();
//        FieldGenerator fieldGenerator = new FieldGenerator(classWriter);
//        fields.forEach(f -> f.accept(fieldGenerator));
        FunctionGenerator functionGenerator = new FunctionGenerator(classWriter);
        methods.forEach(f -> functionGenerator.generate(f));
        classWriter.visitEnd();
        return classWriter.toByteArray();


    }
}
