package pl.kuglin.algorithm;

import java.util.Comparator;
import java.util.List;

public class InsertionSort<T extends Comparable<T>> implements ComparisonSortingAlgorithm<T> {

    @Override
    public void sort(T[] array) {
        sort(array, Comparable::compareTo);
    }

    @Override
    public void sort(List<T> list) {
        sort(list, Comparable::compareTo);
    }

    @Override
    public void sort(T[] array, Comparator<T> comparator) {
        if (array.length < 2)
            return;

        T key;
        int i;

        for (int j = 1; j < array.length; j++) {
            key = array[j];
            i = j - 1;

            while (i >= 0 && comparator.compare(array[i], key) > 0) {
                array[i + 1] = array[i];
                i--;
            }

            array[i + 1] = key;
        }
    }

    @Override
    public void sort(List<T> list, Comparator<T> comparator) {
        if (list.size() < 2)
            return;

        T key;
        int i;

        for (int j = 1; j < list.size(); j++) {
            key = list.get(j);
            i = j - 1;

            while (i >= 0 && comparator.compare(list.get(i), key) > 0) {
                list.set(i + 1, list.get(i));
                i--;
            }

            list.set(i + 1, key);
        }
    }
}
