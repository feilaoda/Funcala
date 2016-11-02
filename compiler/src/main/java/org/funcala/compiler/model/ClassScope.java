package org.funcala.compiler.model;

import com.google.common.collect.LinkedListMultimap;
import com.google.common.collect.Lists;
import org.apache.commons.collections4.map.LinkedMap;
import org.funcala.compiler.type.ClassType;
import org.funcala.compiler.type.Type;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * Created by feilaoda on 16/11/1.
 */
public class ClassScope {
    private String className;
    private String superClassName;

    private final List<FunctionDescription> functionDescriptionList;
    private final LinkedMap<String, LocalVariable> localVariableMap;

    public ClassScope(String className, String superClassName) {
        this.className = className;
        this.superClassName = superClassName;
        functionDescriptionList = new ArrayList<>();
        localVariableMap = new LinkedMap();
    }

    public ClassScope(ClassScope newScope) {
        this.className = newScope.getClassName();
        this.superClassName = newScope.getSuperClassName();
        this.functionDescriptionList = Lists.newArrayList(newScope.getFunctionDescriptionList());
        //TODO
        this.localVariableMap = new LinkedMap<>(newScope.localVariableMap);
    }

    public void addLocalVariable(LocalVariable variable) {
        localVariableMap.put(variable.getName(), variable);
    }

    public LocalVariable getLocalVariable(String varName) {
        return localVariableMap.get(varName);
    }

    public String getClassName() {
        return className;
    }

    public String getSuperClassName() {
        return superClassName;
    }

    public int getLocalVariableIndex(String varName) {
        return localVariableMap.indexOf(varName);
    }

    public Type getClassType() {
        String className = getClassName();
        return new ClassType(className);
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public void setSuperClassName(String superClassName) {
        this.superClassName = superClassName;
    }

    public List<FunctionDescription> getFunctionDescriptionList() {
        return functionDescriptionList;
    }

    public LinkedMap<String, LocalVariable> getLocalVariableMap() {
        return localVariableMap;
    }
}
