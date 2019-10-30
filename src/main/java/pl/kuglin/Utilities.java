package pl.kuglin;

import pl.kuglin.algorithm.MaxSubarray;
import pl.kuglin.algorithm.SortingAlgorithm;

public class Utilities {

    private Utilities() {
    }

    public static <T extends Comparable<T>> void sort(SortingAlgorithm<T> algorithm, T[] array) {
        algorithm.sort(array);
    }

    public static MaxSubarray.Result findMaxSubarray(Double[] arr, int begin, int end) {
        return MaxSubarray.findMaximumSubarray(arr, begin, end);
    }
}
