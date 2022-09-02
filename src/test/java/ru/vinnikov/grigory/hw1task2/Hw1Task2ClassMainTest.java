package ru.vinnikov.grigory.hw1task2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Hw1Task2ClassMainTest {
    public Hw1Task2ClassMainTest() {
    }

    @Test
    void sortArrayTest(){
        // given
        int[] incomingArray = {3,2,1,2};
        int[] sortedArray = {1,2,2,3};
        // when
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
        // result
        Assertions.assertArrayEquals(sortedArray,incomingArray); // exp act
    }
}
