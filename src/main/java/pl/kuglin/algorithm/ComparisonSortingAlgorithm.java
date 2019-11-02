package pl.kuglin.algorithm;

import java.util.Comparator;
import java.util.List;

public interface ComparisonSortingAlgorithm<T extends Comparable<T>> extends SortingAlgorithm<T> {
    void sort(T[] array, Comparator<T> comparator);

    void sort(List<T> list, Comparator<T> comparator);
}
