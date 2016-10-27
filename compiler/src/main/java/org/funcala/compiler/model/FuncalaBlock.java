package org.funcala.compiler.model;

import java.util.List;

/**
 * Created by feilaoda on 16/10/26.
 */
public class FuncalaBlock {
    List<ClassBlock> classBlockList;

    public FuncalaBlock(List<ClassBlock> classBlockList) {
        this.classBlockList = classBlockList;
    }


    public List<ClassBlock> getClassBlockList() {
        return classBlockList;
    }

    public void setClassBlockList(List<ClassBlock> classBlockList) {
        this.classBlockList = classBlockList;
    }
}
