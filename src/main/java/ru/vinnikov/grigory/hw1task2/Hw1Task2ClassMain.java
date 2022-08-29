package ru.vinnikov.grigory.hw1task2;

import java.util.Arrays;

/**
 * Отсортируйте массив [5,6,3,2,5,1,4,9]
 */

public class Hw1Task2ClassMain {
    public static void main(String[] args) {
        int[] incomingArray = new int[]{5,6,3,2,5,1,4,9};
        boolean sortingDone = false;

        while (!sortingDone){
            sortingDone = true;

            for (int i = 1; i < incomingArray.length; i++) {
                if (incomingArray[i] < incomingArray[i - 1]) {
                    int buffer = incomingArray[i - 1];
                    incomingArray[i - 1] = incomingArray[i];
                    incomingArray[i] = buffer;
                    sortingDone = false;
                }
            }
        }

        System.out.println(Arrays.toString(incomingArray));
    }
}