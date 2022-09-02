package ru.vinnikov.grigory.hw1task1;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.HashMap;
import static java.lang.Thread.sleep;

/**
 * Заполните двумерный массив случайным числами и выведите максимальное, минимальное и среднее значение
 */

public class Hw1Task1ClassMain {
    private static final int QTY_AND_SIZE_OF_ARRAYS = 5;
    private static final int RANDOM_DIVIDER = 54321;
    private static final int[][] randomArray = new int[QTY_AND_SIZE_OF_ARRAYS][QTY_AND_SIZE_OF_ARRAYS];
    private static String buffer;
    private static final String minimumWord = "minimum";
    private static final String maximumWord = "maximum";
    private static final String averageWord = "average";
    private static final int MINIMUM = Integer.MAX_VALUE;
    private static final int MAXIMUM = Integer.MIN_VALUE;
    private static HashMap<String, Long> minMaxAverage = new HashMap<>();

    public static void main(String[] args) throws InterruptedException {
        // наполнить массив рандомными числами
        fillinRandomArray();

        // найти минимум, максимум, среднее
        findMinMaxAverage();

        // вывести в консоль максимальное, минимальное и среднее значение
        System.out.println("Максимальное значение = " + minMaxAverage.get(maximumWord) + ". Минимальное значение = "
                + minMaxAverage.get(minimumWord) + ". Среднее значение = " + minMaxAverage.get(averageWord) + ".");
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
        int min = MINIMUM;
        int max = MAXIMUM;
        long average;

        // перебрать каждый элемент массива
        for (int i = 0; i < randomArray.length; i++) {
            for (int j = 0; j < randomArray.length; j++) {
                sum += randomArray[i][j];

                if (randomArray[i][j] < min){
                    min = randomArray[i][j];
                } else if (randomArray[i][j] > max){
                    max = randomArray[i][j];
                }
                qtyElements++;
            }
        }
        minMaxAverage.put(minimumWord, (long) min);
        minMaxAverage.put(maximumWord, (long) max);
        average = sum / qtyElements;
        minMaxAverage.put(averageWord, average);
    }
}
