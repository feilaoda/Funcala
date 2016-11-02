package org.funcala.compiler.bytecode;

import jdk.internal.org.objectweb.asm.MethodVisitor;
import jdk.internal.org.objectweb.asm.Opcodes;
import org.funcala.compiler.model.Argument;
import org.funcala.compiler.model.ClassScope;
import org.funcala.compiler.model.Parameter;
import org.funcala.compiler.model.statement.Expression;
import org.funcala.compiler.model.statement.FunctionCall;
import org.funcala.compiler.type.Type;
import org.funcala.compiler.util.FunctionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by feilaoda on 16/10/26.
 */
public class FunctionCallGenerator {
    private final static Logger LOG = LoggerFactory.getLogger(FunctionCallGenerator.class);
    private final MethodVisitor methodVisitor;
    ExpressionGenerator expressionGenerator;

    public FunctionCallGenerator(ClassScope classScope, ExpressionGenerator expressionGenerator, MethodVisitor methodVisitor) {
        this.expressionGenerator = expressionGenerator;
        this.methodVisitor = methodVisitor;
    }

    public void generate(FunctionCall statement)  {
        LOG.debug("generate function call statement");
        Expression caller = statement.getCaller();
        expressionGenerator.generate(caller);
//        generateArguments(functionCall);
        String functionName = statement.getFunctionName();
        String methodDescriptor = getMethodCallSignature(statement.getArguments(), statement.getType()); // FunctionFactory.getMethodParametersDescriptor(functionCall.getSignature(), statement.getType());
        String ownerDescriptor = statement.getType().getInternalName();
        methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, ownerDescriptor, functionName, methodDescriptor, false);
    }

    public String getMethodCallSignature(List<Argument> arguments, Type type) {
        List<Parameter> parameters = new ArrayList<>();
        return FunctionFactory.getMethodParametersDescriptor(parameters, type);
    }




}
