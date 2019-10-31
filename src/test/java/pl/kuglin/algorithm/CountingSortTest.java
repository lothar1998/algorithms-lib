package pl.kuglin.algorithm;

import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.assertTrue;

public class CountingSortTest {

    private static final int TESTED_EXAMPLES = 1000;
    private static final int ARRAY_MAX_SIZE = 1000;
    private static final int MAX_ARRAY_VALUE = 1000;

    private Random random = new Random();

    @Test
    public void sortInt() {

        SortingAlgorithm<Integer> countingSort = new CountingSort();

        for (int i = 0; i < TESTED_EXAMPLES; i++) {

            int arraySize = random.nextInt(ARRAY_MAX_SIZE);

            Integer[] array = new Integer[arraySize];

            for (int j = 0; j < array.length; j++)
                array[j] = random.nextInt(MAX_ARRAY_VALUE) - MAX_ARRAY_VALUE / 2;

            countingSort.sort(array);

            boolean isProperOrder = true;

            for (int j = 0; j < array.length - 1; j++)
                if (array[j] > array[j + 1]) {
                    isProperOrder = false;
                    break;
                }

            assertTrue(isProperOrder);
        }
    }
}