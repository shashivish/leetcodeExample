package com.example.leetcode.easy;

import java.util.ArrayList;
import java.util.Arrays;

public class DynamicArrayTest {

    public static void main(String[] args) {

        DynamicArray da = new DynamicArray<Integer>();

        System.out.println("Size  : " + da.getSize());
        da.put(1);
        System.out.println("Size  : " + da.getSize());
        da.put(2);
        System.out.println("Size  : " + da.getSize());
        da.put(3);
        System.out.println("Size  : " + da.getSize());
        da.put(4);
        System.out.println("Size  : " + da.getSize());
        da.put(5);
        System.out.println("Size  : " + da.getSize());
        da.put(6);
        System.out.println("Size  : " + da.getSize());

        System.out.println("Array Element by Index  " + da.get(2));

    }


    private static class DynamicArray<T> {
        private T array[];
        private int size = 0;

        @Override
        public String toString() {
            return "DynamicArray{" +
                    "array=" + Arrays.toString(array) +
                    '}';
        }

        public DynamicArray() {
            array = (T[]) new Object[size];

        }

        public int getSize() {
            return array.length;
        }

        public void put(T element) {
            ensureCapacity(size + 1);
            array[size++] = element;

        }

        public T get(int index)
        {
            return array[index];
        }

        private void ensureCapacity(int requestedSize) {

            int currentSize = getSize();

            if (currentSize == 0) {
                array = Arrays.copyOf(array, 1);
                return;
            }

            if (requestedSize > currentSize) {
                int newSize = currentSize * 2;
                array = Arrays.copyOf(array, newSize);
            }


        }


    }


}
