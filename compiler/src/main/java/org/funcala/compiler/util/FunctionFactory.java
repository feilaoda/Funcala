package org.funcala.compiler.util;

import org.funcala.compiler.model.FunctionBlock;
import org.funcala.compiler.model.Parameter;
import org.funcala.compiler.type.Type;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by feilaoda on 16/11/1.
 */
public class FunctionFactory {

    public static String getMethodDescriptor(FunctionBlock function) {
        List<Parameter> parameters = function.getParameters();

        return getMethodParametersDescriptor(parameters, function.getReturnType());
    }


    public static String getMethodParametersDescriptor(Collection<Parameter> parameters, Type returnType) {
        String parametersDescriptor = parameters.stream()
                .map(parameter -> parameter.getType().getDescriptor())
                .collect(Collectors.joining("", "(", ")"));
        String returnDescriptor = returnType.getDescriptor();
        return parametersDescriptor + returnDescriptor;
    }
}
