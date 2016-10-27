package org.funcala.compiler.type;

/**
 * Created by feilaoda on 16/10/26.
 */
public interface Type {
    String getName();
    Class<?> getTypeClass();
    String getDescriptor();
    String getInternalName();
    int getLoadVariableOpcode();
    int getStoreVariableOpcode();
    int getReturnOpcode();
    int getAddOpcode();
    int getSubstractOpcode();
    int getMultiplyOpcode();
    int getDividOpcode();
}
