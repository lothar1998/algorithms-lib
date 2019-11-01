package pl.kuglin.algorithm;

import java.util.List;

import static pl.kuglin.Utilities.swap;

public class BubbleSort<T extends Comparable<T>> implements SortingAlgorithm<T> {

    @Override
    public void sort(List<T> list) {
        for (int i = 0; i < list.size(); i++)
            for (int j = list.size() - 1; j > i; j--)
                if (list.get(j).compareTo(list.get(j - 1)) < 0)
                    swap(list, j, j - 1);
    }

    @Override
    public void sort(T[] array) {
        for (int i = 0; i < array.length; i++)
            for (int j = array.length - 1; j > i; j--)
                if (array[j].compareTo(array[j - 1]) < 0)
                    swap(array, j, j - 1);
    }
}
