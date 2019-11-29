package pl.kuglin;

import pl.kuglin.algorithm.*;
import pl.kuglin.datastructure.BinarySearchTree;

import java.util.Comparator;
import java.util.List;

public class Utilities {

    private Utilities() {
    }

    public static <T extends Comparable<T>> void sort(SortingAlgorithm<T> algorithm, T[] array) {
        algorithm.sort(array);
    }

    public static <T extends Comparable<T>> void sort(SortingAlgorithm<T> algorithm, List<T> list) {
        algorithm.sort(list);
    }

    public static <T extends Comparable<T>> void sort(ComparisonSortingAlgorithm<T> algorithm, T[] array, Comparator<T> comparator) {
        algorithm.sort(array, comparator);
    }

    public static <T extends Comparable<T>> void sort(ComparisonSortingAlgorithm<T> algorithm, List<T> list, Comparator<T> comparator) {
        algorithm.sort(list, comparator);
    }

    @SafeVarargs
    public static <T> void sort(RadixSort<T> algorithm, T[] array, Comparator<T>... comparators) {
        algorithm.sort(array, comparators);
    }

    @SafeVarargs
    public static <T> void sort(RadixSort<T> algorithm, List<T> list, Comparator<T>... comparators) {
        algorithm.sort(list, comparators);
    }

    public static <E extends BinarySearchTree.Node<T>, T extends Comparable<T>> void sort(TreeSort<E, T> algorithm, E[] array){
        algorithm.sort(array);
    }

    public static <E extends BinarySearchTree.Node<T>, T extends Comparable<T>> void sort(TreeSort<E, T> algorithm, List<E> list){
        algorithm.sort(list);
    }

    public static MaxSubarray.Result findMaxSubarray(Double[] arr, int begin, int end) {
        return MaxSubarray.findMaximumSubarray(arr, begin, end);
    }

    /**
     * select element with n-th value from array
     *
     * @param array         array of comparable types
     * @param valuePosition n-th value of element
     * @param <T>           comparable type
     * @return element with n-th value
     */
    public static <T extends Comparable<T>> T selectElementFromArray(T[] array, int valuePosition) {
        return ArrayElementSelection.partitionSelect(array, 0, array.length - 1, valuePosition);
    }

    public static <T> void swap(List<T> list, int i, int j) {
        T temp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, temp);
    }

    public static <T> void swap(T[] array, int i, int j) {
        T temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
