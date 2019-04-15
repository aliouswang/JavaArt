package com.aliouswang.olympic.stat;

public interface IStack<T> {

    void push(T t);

    T pop();

    int size();

    boolean isEmpty();

}
