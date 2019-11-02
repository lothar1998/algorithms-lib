package pl.kuglin.algorithm;

import java.util.Comparator;
import java.util.List;

import static pl.kuglin.Utilities.swap;

public class BubbleSort<T extends Comparable<T>> implements ComparisonSortingAlgorithm<T> {

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
        for (int i = 0; i < array.length; i++)
            for (int j = array.length - 1; j > i; j--)
                if (comparator.compare(array[j], (array[j - 1])) < 0)
                    swap(array, j, j - 1);
    }

    @Override
    public void sort(List<T> list, Comparator<T> comparator) {
        for (int i = 0; i < list.size(); i++)
            for (int j = list.size() - 1; j > i; j--)
                if (comparator.compare(list.get(j), list.get(j - 1)) < 0)
                    swap(list, j, j - 1);
    }
}
