package ru.vinnikov.grigory.hw1task1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Hw1Task1ClassMainTest {
    public Hw1Task1ClassMainTest() {
    }

    @Test
    void findMinTest(){
        // given
        int MAXIMUM = 1;
        int MINIMUM = 5;
        int assertMINIMUM = 1;
        int[][] randomArray = {{1,2,3},{2,3,4},{3,4,5}};

        // when do перебрать каждый элемент массива
        for (int i = 0; i < randomArray.length; i++) {
            for (int j = 0; j < randomArray.length; j++) {
                if (randomArray[i][j] < MINIMUM){
                    MINIMUM = randomArray[i][j];
                } else if (randomArray[i][j] > MAXIMUM){
                    MAXIMUM = randomArray[i][j];
                }
            }
        }

        // result
        Assertions.assertEquals(assertMINIMUM,MINIMUM); // exp act
    }

    @Test
    void findMaxTest(){
        // given
        int MAXIMUM = 1;
        int assertMAXIMUM = 5;
        int MINIMUM = 5;
        int[][] randomArray = {{1,2,3},{2,3,4},{3,4,5}};

        // when do перебрать каждый элемент массива
        for (int i = 0; i < randomArray.length; i++) {
            for (int j = 0; j < randomArray.length; j++) {
                if (randomArray[i][j] < MINIMUM){
                    MINIMUM = randomArray[i][j];
                } else if (randomArray[i][j] > MAXIMUM){
                    MAXIMUM = randomArray[i][j];
                }
            }
        }

        // result
        Assertions.assertEquals(assertMAXIMUM,MAXIMUM); // exp act
    }
}
