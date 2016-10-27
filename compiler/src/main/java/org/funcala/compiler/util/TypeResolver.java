package org.funcala.compiler.util;

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
        return getFromValue(stringValue);
    }

    public static Type getFromValue(String stringValue) {
        if (StringUtils.isEmpty(stringValue)) return BasicType.VOID;
        if (stringValue.equals("Int")) {
            return BasicType.INT;
        } else if (stringValue.equals("String")) {
            return BasicType.STRING;
        }
        return BasicType.STRING;
    }

    public static Object getValueFromString(String stringValue, Type type) {
        if (isInt(type)) {
            return Integer.valueOf(stringValue);
        }
        if (isFloat(type)) {
            return Float.valueOf(stringValue);
        }
        if (isDouble(type)) {
            return Double.valueOf(stringValue);
        }
        if (isBool(type)) {
            return Boolean.valueOf(stringValue);
        }
        if (type == BasicType.STRING) {
            stringValue = StringUtils.removeStart(stringValue, "\"");
            stringValue = StringUtils.removeEnd(stringValue, "\"");
            return stringValue;
        }
        throw new AssertionError("Objects not yet implemented!");
    }

    public static boolean isInt(Type type) {
        return type == BasicType.INT;
    }

    public static boolean isBool(Type type) {
        return type == BasicType.BOOLEAN;
    }

    public static boolean isFloat(Type type) {
        return type == BasicType.FLOAT;
    }

    public static boolean isDouble(Type type) {
        return type == BasicType.DOUBLE;
    }

}
