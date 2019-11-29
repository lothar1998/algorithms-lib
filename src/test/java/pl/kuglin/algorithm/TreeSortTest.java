package pl.kuglin.algorithm;

import org.junit.Test;
import pl.kuglin.datastructure.BinarySearchTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.junit.Assert.assertTrue;

public class TreeSortTest {

    private static final int TESTED_EXAMPLES = 1000;
    private static final int CONTAINER_MAX_SIZE = 1000;
    private static final int MAX_ARRAY_VALUE = 1000;

    private static class ObjectTestInteger extends BinarySearchTree.Node<Integer> {
        public ObjectTestInteger(Integer id) {
            super(id);
        }
    }

    private static class ObjectTestDouble extends BinarySearchTree.Node<Double> {
        public ObjectTestDouble(Double id) {
            super(id);
        }
    }

    private Random random = new Random();

    private ObjectTestInteger[] arrayInteger;
    private ObjectTestDouble[] arrayDouble;
    private List<ObjectTestInteger> listInteger;
    private List<ObjectTestDouble> listDouble;

    private void initArrayInteger() {
        int arraySize = random.nextInt(CONTAINER_MAX_SIZE);

        arrayInteger = new ObjectTestInteger[arraySize];

        for (int j = 0; j < arrayInteger.length; j++)
            arrayInteger[j] = new ObjectTestInteger(random.nextInt(MAX_ARRAY_VALUE));
    }

    private void initArrayDouble() {
        int arraySize = random.nextInt(CONTAINER_MAX_SIZE);

        arrayDouble = new ObjectTestDouble[arraySize];

        for (int j = 0; j < arrayDouble.length; j++)
            arrayDouble[j] = new ObjectTestDouble(random.nextDouble() * MAX_ARRAY_VALUE);
    }

    private void initListInteger() {
        listInteger = new ArrayList<>();

        for (int j = 0; j < CONTAINER_MAX_SIZE; j++)
            listInteger.add(new ObjectTestInteger(random.nextInt(MAX_ARRAY_VALUE)));
    }

    private void initListDouble() {
        listDouble = new ArrayList<>();

        for (int j = 0; j < CONTAINER_MAX_SIZE; j++)
            listDouble.add(new ObjectTestDouble(random.nextDouble() * MAX_ARRAY_VALUE));
    }

    private <E extends BinarySearchTree.Node<T>, T extends Comparable<T>> void testOrder(E[] array) {
        boolean isProperOrder = true;

        for (int j = 0; j < array.length - 1; j++)
            if (array[j].getId().compareTo(array[j + 1].getId()) > 0) {
                isProperOrder = false;
                break;
            }

        assertTrue(isProperOrder);
    }

    private <E extends BinarySearchTree.Node<T>, T extends Comparable<T>> void testOrder(List<E> list) {
        boolean isProperOrder = true;

        for (int j = 0; j < list.size() - 1; j++)
            if (list.get(j).getId().compareTo(list.get(j + 1).getId()) > 0) {
                isProperOrder = false;
                break;
            }

        assertTrue(isProperOrder);
    }

    @Test
    public void sortByIntegerArray() {

        TreeSort<ObjectTestInteger, Integer> treeSort = new TreeSort<>();

        for (int i = 0; i < TESTED_EXAMPLES; i++) {

            initArrayInteger();

            treeSort.sort(arrayInteger);

            testOrder(arrayInteger);
        }
    }

    @Test
    public void sortByDoubleArray() {

        TreeSort<ObjectTestDouble, Double> treeSort = new TreeSort<>();

        for (int i = 0; i < TESTED_EXAMPLES; i++) {

            initArrayDouble();

            treeSort.sort(arrayDouble);

            testOrder(arrayDouble);
        }
    }

    @Test
    public void sortByIntegerList() {

        TreeSort<ObjectTestInteger, Integer> treeSort = new TreeSort<>();

        for (int i = 0; i < TESTED_EXAMPLES; i++) {

            initListInteger();

            treeSort.sort(listInteger);

            testOrder(listInteger);
        }
    }

    @Test
    public void sortByDoubleList() {

        TreeSort<ObjectTestDouble, Double> treeSort = new TreeSort<>();

        for (int i = 0; i < TESTED_EXAMPLES; i++) {

            initListDouble();

            treeSort.sort(listDouble);

            testOrder(listDouble);
        }
    }

}