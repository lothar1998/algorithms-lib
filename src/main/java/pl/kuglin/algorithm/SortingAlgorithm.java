package pl.kuglin.algorithm;

import java.util.List;

public interface SortingAlgorithm<T> {
    void sort(T[] array);
    void sort(List<T> list);
}
