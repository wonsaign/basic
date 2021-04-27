package com.learn.java.lang.wangs.base.collection;

public class ArrayTest {

    long[] elementData;

    int size;

    private Long remove(int index){
        long oldV = 1;

        int numMoved = size - index - 1;

        if(numMoved > 0){
            System.arraycopy(elementData, index + 1, elementData, index, numMoved);
        }
        elementData[--size] = 0;

        return oldV;
    }

    public static void main(String[] args) {
        ArrayTest arrayTest = new ArrayTest();

        int size = 4;

        arrayTest.elementData = new long[size];
        arrayTest.size = 5;

        for (int i = 0; i < size; i++) {
            arrayTest.elementData[i] = i;
        }

        arrayTest.remove(2);
        System.out.println(arrayTest.elementData);
    }

//
//    public static void main(String[] args) {
//        ArrayTest arrayTest = new ArrayTest();
//
//        int size = 4;
//
//        arrayTest.elementData = new long[size];
//        arrayTest.size = 9;
//        long[] elementData = arrayTest.elementData;
//
//        for (int i = 0; i < size; i++) {
//            arrayTest.elementData[i] = i;
//        }
//
//        int index = 2;
//
//        int numMoved = 1;
//
//        System.arraycopy(elementData, index + 1, elementData, index, numMoved);
//    }
}
