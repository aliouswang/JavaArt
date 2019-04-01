package com.aliouswang.olympic.generic;

import com.aliouswang.olympic.generic.bean.Fruit;

public class GenericPlayground {

    public static void main(String[] args) throws IllegalAccessException, InstantiationException, ClassNotFoundException {
        Class clazz = Fruit.class;
        GenericUtil.parseMethod(clazz);
    }

}
