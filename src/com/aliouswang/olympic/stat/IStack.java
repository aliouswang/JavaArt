package com.aliouswang.olympic.stat;

public interface IStack<T> {

    void push(T item);

    T pop();

    boolean isEmpty();

    int size();

}
