package com.aliouswang.olympic.stat;

public class Stack<T> implements IStack<T>{

    private T[] items;

    private int size;

    @Override
    public void push(T item) {

    }

    @Override
    public T pop() {
        return null;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public int size() {
        return this.size;
    }
}
