package pl.kuglin.algorithm;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.junit.Assert.assertTrue;

public class CountingSortTest {

    private static final int TESTED_EXAMPLES = 1000;
    private static final int CONTAINER_MAX_SIZE = 1000;
    private static final int MAX_ARRAY_VALUE = 1000;

    private Random random = new Random();

    @Test
    public void sortIntArray() {

        SortingAlgorithm<Integer> countingSort = new CountingSort();

        for (int i = 0; i < TESTED_EXAMPLES; i++) {

            int arraySize = random.nextInt(CONTAINER_MAX_SIZE);

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

    @Test
    public void sortIntList() {

        SortingAlgorithm<Integer> countingSort = new CountingSort();

        for (int i = 0; i < TESTED_EXAMPLES; i++) {

            List<Integer> list = new ArrayList<>();

            for (int j = 0; j < CONTAINER_MAX_SIZE; j++)
                list.add(random.nextInt(MAX_ARRAY_VALUE));

            countingSort.sort(list);

            boolean isProperOrder = true;

            for (int j = 0; j < list.size() - 1; j++)
                if (list.get(j) > list.get(j + 1)) {
                    isProperOrder = false;
                    break;
                }

            assertTrue(isProperOrder);
        }
    }
}