package org.funcala.compiler.parser.statement;

import org.funcala.compiler.antlr.FuncalaBaseVisitor;
import org.funcala.compiler.antlr.FuncalaParser;
import org.funcala.compiler.model.ClassScope;
import org.funcala.compiler.model.LocalVariable;
import org.funcala.compiler.model.statement.LocalVariableReference;
import org.funcala.compiler.model.statement.Reference;
import org.funcala.compiler.model.statement.ValueExpression;
import org.funcala.compiler.type.TypeResolver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by feilaoda on 16/10/27.
 */
public class VariableReferenceVisitor extends FuncalaBaseVisitor<Reference> {
    private static final Logger LOG = LoggerFactory.getLogger(VariableReferenceVisitor.class);

    private ClassScope classScope;

    public VariableReferenceVisitor(ClassScope classScope) {
        this.classScope = classScope;
    }

    @Override
    public Reference visitVarReferenceExpression(FuncalaParser.VarReferenceExpressionContext ctx) {
        String varName = ctx.varReference().NAME().getText();
        LocalVariable variable = classScope.getLocalVariable(varName);
        Reference var = new LocalVariableReference(variable);
        return var;
    }


}
