package pl.kuglin.algorithm;

import java.util.List;

public interface SortingAlgorithm<T extends Comparable<T>> {
    void sort(T[] array);

    void sort(List<T> list);
}
