package pl.kuglin.sortingalgorithms;

@FunctionalInterface
public interface SortingAlgorithm<T extends Comparable<T>> {
    void sort(T[] array);
}
