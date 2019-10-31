package pl.kuglin;

import pl.kuglin.algorithm.MaxSubarray;
import pl.kuglin.algorithm.RadixSort;
import pl.kuglin.algorithm.SortingAlgorithm;

import java.util.Comparator;
import java.util.List;

public class Utilities {

    private Utilities() {
    }

    public static <T extends Comparable<T>> void sort(SortingAlgorithm<T> algorithm, T[] array) {
        algorithm.sort(array);
    }

    @SafeVarargs
    public static <T> void sort(RadixSort<T> algorithm, T[] array, Comparator<T>... comparators) {
        algorithm.sort(array, comparators);
    }

    @SafeVarargs
    public static <T> void sort(RadixSort<T> algorithm, List<T> list, Comparator<T>... comparators) {
        algorithm.sort(list, comparators);
    }

    public static MaxSubarray.Result findMaxSubarray(Double[] arr, int begin, int end) {
        return MaxSubarray.findMaximumSubarray(arr, begin, end);
    }
}
