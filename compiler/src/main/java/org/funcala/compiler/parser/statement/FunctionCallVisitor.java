package org.funcala.compiler.parser.statement;

import org.funcala.compiler.antlr.FuncalaBaseVisitor;
import org.funcala.compiler.antlr.FuncalaParser;
import org.funcala.compiler.model.Argument;
import org.funcala.compiler.model.ClassScope;
import org.funcala.compiler.model.statement.Expression;
import org.funcala.compiler.model.statement.FunctionCall;
import org.funcala.compiler.model.LocalVariable;
import org.funcala.compiler.model.statement.LocalVariableReference;
import org.funcala.compiler.type.ClassType;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by feilaoda on 16/10/27.
 */
public class FunctionCallVisitor extends FuncalaBaseVisitor<FunctionCall> {

    private final ExpressionVisitor expressionVisitor;
    private ClassScope classScope;

    public FunctionCallVisitor(ClassScope classScope, ExpressionVisitor expressionVisitor) {
        this.classScope = classScope;
        this.expressionVisitor = expressionVisitor;
    }

    @Override
    public FunctionCall visitFunctionCallExpression(FuncalaParser.FunctionCallExpressionContext ctx) {
        String functionName = ctx.functionName().getText();
//        ArgumentVisitor argumentVisitor = new ArgumentVisitor();
        List<Argument> argumentList = new ArrayList<>(); //= ctx.argumentList().argument().stream().map(a->a.accept(argumentVisitor)).collect(Collectors.toList())
        Expression caller;
        if (ctx.caller != null) {
            caller = ctx.caller.accept(expressionVisitor);
            return new FunctionCall(functionName, caller, argumentList);
        }

        ClassType classType = new ClassType(classScope.getClassName());
        LocalVariable variable = new LocalVariable("this", classType);
        return new FunctionCall(functionName, new LocalVariableReference(variable), argumentList);
    }

}
