package pl.kuglin.algorithm;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.junit.Assert.assertTrue;

public class BucketSortTest {

    private static final int TESTED_EXAMPLES = 1000;
    private static final int CONTAINER_MAX_SIZE = 1000;

    private Double[] arrayDouble;

    private Random random = new Random();
    private List<Double> listDouble;

    private void initArrayDouble() {
        int arraySize = random.nextInt(CONTAINER_MAX_SIZE);

        arrayDouble = new Double[arraySize];

        for (int j = 0; j < arrayDouble.length; j++)
            arrayDouble[j] = random.nextDouble();
    }

    private void initListDouble() {
        listDouble = new ArrayList<>();

        for (int j = 0; j < CONTAINER_MAX_SIZE; j++)
            listDouble.add(random.nextDouble());
    }

    private <T extends Comparable<T>> void testOrder(T[] array, Order order) {
        boolean isProperOrder = true;

        switch (order) {
            case INCREASING:
                for (int j = 0; j < array.length - 1; j++)
                    if (array[j].compareTo(array[j + 1]) > 0) {
                        isProperOrder = false;
                        break;
                    }
                break;
            case DECREASING:
                for (int j = 0; j < array.length - 1; j++)
                    if (array[j].compareTo(array[j + 1]) < 0) {
                        isProperOrder = false;
                        break;
                    }
                break;
        }

        assertTrue(isProperOrder);
    }

    private <T extends Comparable<T>> void testOrder(List<T> list, Order order) {
        boolean isProperOrder = true;

        switch (order) {
            case INCREASING:
                for (int j = 0; j < list.size() - 1; j++)
                    if (list.get(j).compareTo(list.get(j + 1)) > 0) {
                        isProperOrder = false;
                        break;
                    }
                break;
            case DECREASING:
                for (int j = 0; j < list.size() - 1; j++)
                    if (list.get(j).compareTo(list.get(j + 1)) < 0) {
                        isProperOrder = false;
                        break;
                    }
                break;
        }

        assertTrue(isProperOrder);
    }

    @Test
    public void sortIncreasingOrderDoubleArray() {

        SortingAlgorithm<Double> bucketSort = new BucketSort();

        for (int i = 0; i < TESTED_EXAMPLES; i++) {

            initArrayDouble();

            bucketSort.sort(arrayDouble);

            testOrder(arrayDouble, Order.INCREASING);
        }
    }

    @Test
    public void sortIncreasingOrderDoubleList() {

        SortingAlgorithm<Double> bucketSort = new BucketSort();

        for (int i = 0; i < TESTED_EXAMPLES; i++) {

            initListDouble();

            bucketSort.sort(listDouble);

            testOrder(listDouble, Order.INCREASING);
        }
    }

    enum Order {
        INCREASING,
        DECREASING
    }
}