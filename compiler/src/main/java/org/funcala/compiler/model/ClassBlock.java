package org.funcala.compiler.model;

import java.util.List;

/**
 * Created by feilaoda on 16/10/26.
 */
public class ClassBlock {
    String name;
    List<FunctionBlock> functionBlockList;

    public ClassBlock(String name, List<FunctionBlock> functionBlocks) {
        this.name = name;
        functionBlockList = functionBlocks;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<FunctionBlock> getFunctionBlockList() {
        return functionBlockList;
    }

    public void setFunctionBlockList(List<FunctionBlock> functionBlockList) {
        this.functionBlockList = functionBlockList;
    }
}
