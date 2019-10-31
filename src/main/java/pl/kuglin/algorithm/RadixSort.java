package pl.kuglin.algorithm;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Radix Sort algorithm
 *
 * @param <T> type of sorted array or list
 */
public class RadixSort<T> {

    /**
     * radix sort array
     *
     * @param array       array to be sorted
     * @param comparators comparator of each sorting level in order from the least significant to the most significant
     */
    @SafeVarargs
    public final void sort(T[] array, Comparator<T>... comparators) {
        for (Comparator<T> i : comparators)
            Arrays.sort(array, i);
    }

    /**
     * radix sort list
     *
     * @param list        list to be sorted
     * @param comparators comparator of each sorting level in order from the least significant to the most significant
     */
    @SafeVarargs
    public final void sort(List<T> list, Comparator<T>... comparators) {
        for (Comparator<T> i : comparators)
            list.sort(i);
    }
}
