package com.aliouswang.olympic.generic;

import com.aliouswang.olympic.util.Log;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;

public class GenericUtil {

    public static void parseMethod(Class clazz) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Method[] methods = clazz.getDeclaredMethods();
        if (methods.length <= 0) throw new IllegalStateException("no method to parse");
        Method method = methods[0];
        Type type = method.getGenericReturnType();
        if (type instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) type;
            Type[] types = parameterizedType.getActualTypeArguments();
            if (types != null) {
                Type type1 = types[0];
                type1.getTypeName();
                Log.d("parametrized type name : " + type1.getTypeName());
                Object object = Class.forName(type1.getTypeName()).newInstance();
                if (object != null) {

                }
            }
        }

        Type[] types = method.getGenericParameterTypes();
        if (types != null) {
            Type type2 = types[1];
            if (type2 instanceof ParameterizedType) {
                ParameterizedType parameterizedType = (ParameterizedType) type2;
                Type[] actual = parameterizedType.getActualTypeArguments();
                if (actual != null) {
                    Type actual2 = actual[0];
                    if (actual2 instanceof WildcardType) {
                        WildcardType wildcardType = (WildcardType) actual2;
                        Type[] upperBounds = wildcardType.getUpperBounds();
                        if (upperBounds != null) {
                            Type upType = upperBounds[0];

                        }
                    }
                }
            }
        }
    }

}
