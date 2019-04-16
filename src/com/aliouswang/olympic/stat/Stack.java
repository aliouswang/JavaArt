package com.aliouswang.olympic.stat;

import java.lang.reflect.Array;

public class Stack<T> implements IStack<T>{

    private static final int DEFAULT_SIZE = 16;

    private T[] datas;
    private int size;

    public Stack() {
        this(DEFAULT_SIZE);
    }

    public Stack(int capacity) {
        datas = (T[]) new Object[capacity];
    }

    @Override
    public void push(T t) {
        if (size >= datas.length - 1) {
            resize(size * 2);
        }
        datas[size++] = t;
    }

    @Override
    public T pop() {
        if (isEmpty()) return null;
        T data = datas[--size];
        datas[size] = null;
        if (size <= datas.length/4) {
            resize(datas.length/2);
        }
        return data;
    }

    private void resize(int newSize) {
        T[] newDatas = (T[]) new Object[newSize];
        System.arraycopy(datas, 0, newDatas, 0, size);
        this.datas = newDatas;
    }


    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }
}
