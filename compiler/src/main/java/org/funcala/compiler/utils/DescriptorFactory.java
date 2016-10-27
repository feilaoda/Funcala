package org.funcala.compiler.utils;

import org.funcala.compiler.model.FunctionBlock;

/**
 * Created by feilaoda on 16/10/26.
 */
public final class DescriptorFactory {

    public static String getMethodDescriptor(FunctionBlock function) {
//        Collection<Parameter> parameters = function.getParameters();
//        Type returnType = function.getReturnType();
//        return getMethodDescriptor(parameters, returnType);

        return "()" + " void ";
    }

//    public static String getMethodDescriptor(FunctionSignature signature) {
//        Collection<Parameter> parameters = signature.getParameters();
//        Type returnType = signature.getReturnType();
//        return getMethodDescriptor(parameters, returnType);
//    }
//
//    private static String getMethodDescriptor(Collection<Parameter> parameters, Type returnType) {
//        String parametersDescriptor = parameters.stream()
//                .map(parameter -> parameter.getType().getDescriptor())
//                .collect(Collectors.joining("", "(", ")"));
//        String returnDescriptor = returnType.getDescriptor();
//        return parametersDescriptor + returnDescriptor;
//    }
}
