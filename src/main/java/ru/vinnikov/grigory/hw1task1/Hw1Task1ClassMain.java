package ru.vinnikov.grigory.hw1task1;

import java.time.LocalDateTime;
import java.util.Arrays;
import static java.lang.Thread.sleep;

/**
 * Заполните двумерный массив случайным числами и выведите максимальное, минимальное и среднее значение
 */

public class Hw1Task1ClassMain {
    private static final int QTY_AND_SIZE_OF_ARRAYS = 5;
    private static final int RANDOM_DIVIDER = 54321;
    private static final int[][] randomArray = new int[QTY_AND_SIZE_OF_ARRAYS][QTY_AND_SIZE_OF_ARRAYS];
    private static String buffer;
    private static long average; // среднее значение
    private static int MINIMUM = Integer.MAX_VALUE;
    private static int MAXIMUM = Integer.MIN_VALUE;

    public static void main(String[] args) throws InterruptedException {
        // наполнить массив рандомными числами
        fillinRandomArray();

        // найти минимум, максимум, среднее
        findMinMaxAverage();

        // вывести в консоль максимальное, минимальное и среднее значение
        System.out.println("Максимальное значение = " + MAXIMUM + ". Минимальное значение = " + MINIMUM + ". Среднее " +
                        "значение = " + average + ".");
    }

    public static void fillinRandomArray() throws InterruptedException {
        // наполнить рандомными числами
        buffer = "";
        for (int i = 0; i < randomArray.length; i++) {
            sleep(9);
            for (int j = 0; j < randomArray.length; j++) {
                LocalDateTime dateTime = LocalDateTime.now();

                int random = dateTime.getNano() / (RANDOM_DIVIDER + i + j);
                // проверить, было ли уже такое число, если нет, то положить в массив
                String checkIt = random + "";
                // если такое число уже есть, то ищем снова, если нет, то положить в массив
                if (buffer.contains(checkIt)){
//                    System.out.println(checkIt + " дубль: " + buffer);
                    sleep(99);
                    j--;
                } else {
                    randomArray[i][j] = random;
                    buffer = buffer + random + ",";
                }
//                System.out.println("buffer: " + buffer);
            }
        }
//                System.out.println("11:" + Arrays.deepToString(randomArray));
    }

    public static void findMinMaxAverage(){
        long sum = 0;
        int qtyElements = 0;

        // перебрать каждый элемент массива
        for (int i = 0; i < randomArray.length; i++) {
            for (int j = 0; j < randomArray.length; j++) {
                sum += randomArray[i][j];

                if (randomArray[i][j] < MINIMUM){
                    MINIMUM = randomArray[i][j];
                } else if (randomArray[i][j] > MAXIMUM){
                    MAXIMUM = randomArray[i][j];
                }
                qtyElements++;
            }
        }
        average = sum / qtyElements;
//        System.out.println("MINIMUM: " + MINIMUM);
//        System.out.println("MAXIMUM: " + MAXIMUM);
//        System.out.println("average: " + average);
    }
}
