package pl.kuglin.algorithm;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import static org.junit.Assert.assertTrue;

public class InsertionSortTest {

    private static final int TESTED_EXAMPLES = 1000;
    private static final int CONTAINER_MAX_SIZE = 1000;
    private static final int MAX_ARRAY_VALUE = 1000;

    private Integer[] arrayInteger;

    private Random random = new Random();
    private Double[] arrayDouble;
    private List<Integer> listInteger;
    private List<Double> listDouble;

    private void initArrayInteger() {
        int arraySize = random.nextInt(CONTAINER_MAX_SIZE);

        arrayInteger = new Integer[arraySize];

        for (int j = 0; j < arrayInteger.length; j++)
            arrayInteger[j] = random.nextInt(MAX_ARRAY_VALUE);
    }

    private void initArrayDouble() {
        int arraySize = random.nextInt(CONTAINER_MAX_SIZE);

        arrayDouble = new Double[arraySize];

        for (int j = 0; j < arrayDouble.length; j++)
            arrayDouble[j] = random.nextDouble() * MAX_ARRAY_VALUE;
    }

    private void initListInteger() {
        listInteger = new ArrayList<>();

        for (int j = 0; j < CONTAINER_MAX_SIZE; j++)
            listInteger.add(random.nextInt(MAX_ARRAY_VALUE));
    }

    private void initListDouble() {
        listDouble = new ArrayList<>();

        for (int j = 0; j < CONTAINER_MAX_SIZE; j++)
            listDouble.add(random.nextDouble() * MAX_ARRAY_VALUE);
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
    public void sortIncreasingOrderIntArray() {

        ComparisonSortingAlgorithm<Integer> insertionSort = new InsertionSort<>();

        for (int i = 0; i < TESTED_EXAMPLES; i++) {

            initArrayInteger();

            insertionSort.sort(arrayInteger);

            testOrder(arrayInteger, Order.INCREASING);
        }
    }

    @Test
    public void sortIncreasingOrderDoubleArray() {

        ComparisonSortingAlgorithm<Double> insertionSort = new InsertionSort<>();

        for (int i = 0; i < TESTED_EXAMPLES; i++) {

            initArrayDouble();

            insertionSort.sort(arrayDouble);

            testOrder(arrayDouble, Order.INCREASING);
        }
    }

    @Test
    public void sortIncreasingOrderIntList() {

        ComparisonSortingAlgorithm<Integer> insertionSort = new InsertionSort<>();

        for (int i = 0; i < TESTED_EXAMPLES; i++) {

            initListInteger();

            insertionSort.sort(listInteger);

            testOrder(listInteger, Order.INCREASING);
        }
    }

    @Test
    public void sortIncreasingOrderDoubleList() {

        ComparisonSortingAlgorithm<Double> insertionSort = new InsertionSort<>();

        for (int i = 0; i < TESTED_EXAMPLES; i++) {

            initListDouble();

            insertionSort.sort(listDouble);

            testOrder(listDouble, Order.INCREASING);
        }
    }

    @Test
    public void sortDecreasingOrderIntArray() {

        ComparisonSortingAlgorithm<Integer> insertionSort = new InsertionSort<>();

        for (int i = 0; i < TESTED_EXAMPLES; i++) {

            initArrayInteger();

            insertionSort.sort(arrayInteger, Collections.reverseOrder());

            testOrder(arrayInteger, Order.DECREASING);
        }
    }

    @Test
    public void sortDecreasingOrderDoubleArray() {

        ComparisonSortingAlgorithm<Double> insertionSort = new InsertionSort<>();

        for (int i = 0; i < TESTED_EXAMPLES; i++) {

            initArrayDouble();

            insertionSort.sort(arrayDouble, Collections.reverseOrder());

            testOrder(arrayDouble, Order.DECREASING);
        }
    }

    @Test
    public void sortDecreasingOrderIntList() {

        ComparisonSortingAlgorithm<Integer> insertionSort = new InsertionSort<>();

        for (int i = 0; i < TESTED_EXAMPLES; i++) {

            initListInteger();

            insertionSort.sort(listInteger, Collections.reverseOrder());

            testOrder(listInteger, Order.DECREASING);
        }
    }

    @Test
    public void sortDecreasingOrderDoubleList() {

        ComparisonSortingAlgorithm<Double> insertionSort = new InsertionSort<>();

        for (int i = 0; i < TESTED_EXAMPLES; i++) {

            initListDouble();

            insertionSort.sort(listDouble, Collections.reverseOrder());

            testOrder(listDouble, Order.DECREASING);
        }
    }

    enum Order {
        INCREASING,
        DECREASING
    }
}