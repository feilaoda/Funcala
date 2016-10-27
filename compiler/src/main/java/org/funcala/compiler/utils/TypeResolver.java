package org.funcala.compiler.utils;

import org.apache.commons.lang3.StringUtils;
import org.funcala.compiler.antlr.FuncalaParser;
import org.funcala.compiler.type.BasicType;
import org.funcala.compiler.type.Type;

/**
 * Created by feilaoda on 16/10/26.
 */
public class TypeResolver {
    public static Type getFromTypeContext(FuncalaParser.TypeContext typeContext) {
        String stringValue = typeContext.getText();
        if (StringUtils.isEmpty(stringValue)) return BasicType.VOID;
        if (stringValue.equals("Int")) {
            return BasicType.INT;
        } else if (stringValue.equals("String")) {
            return BasicType.STRING;
        }
        return BasicType.STRING;
    }

}
