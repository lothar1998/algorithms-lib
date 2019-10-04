package pl.kuglin;

import pl.kuglin.sortingalgorithms.SortingAlgorithm;

public class Utilities {

    private Utilities() {
    }

    public static <T extends Comparable<T>> void sort(SortingAlgorithm<T> algorithm, T[] array) {
        algorithm.sort(array);
    }
}
