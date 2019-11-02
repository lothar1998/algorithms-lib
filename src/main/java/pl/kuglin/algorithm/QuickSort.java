package pl.kuglin.algorithm;

import java.util.Comparator;
import java.util.List;
import java.util.Random;

import static pl.kuglin.Utilities.swap;

public class QuickSort<T extends Comparable<T>> implements ComparisonSortingAlgorithm<T> {

    private static Random random = new Random();

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
        quickSort(array, 0, array.length - 1, comparator);
    }

    @Override
    public void sort(List<T> list, Comparator<T> comparator) {
        quickSort(list, 0, list.size() - 1, comparator);
    }

    private void quickSort(T[] array, int p, int r, Comparator<T> comparator) {
        if (p < r) {
            int q = randomPartition(array, p, r, comparator);
            quickSort(array, p, q - 1, comparator);
            quickSort(array, q + 1, r, comparator);
        }
    }

    private void quickSort(List<T> list, int p, int r, Comparator<T> comparator) {
        if (p < r) {
            int q = randomPartition(list, p, r, comparator);
            quickSort(list, p, q - 1, comparator);
            quickSort(list, q + 1, r, comparator);
        }
    }

    private int randomPartition(T[] array, int p, int r, Comparator<T> comparator) {
        swap(array, r, random.nextInt((r - p) + 1) + p);
        return partition(array, p, r, comparator);
    }

    private int randomPartition(List<T> list, int p, int r, Comparator<T> comparator) {
        swap(list, r, random.nextInt((r - p) + 1) + p);
        return partition(list, p, r, comparator);
    }

    private int partition(T[] array, int p, int r, Comparator<T> comparator) {
        T x = array[r];

        int i = p - 1;

        for (int j = p; j < r; j++) {
            if (comparator.compare(array[j], x) < 0) {
                i++;
                swap(array, i, j);
            }
        }

        swap(array, i + 1, r);

        return i + 1;
    }

    private int partition(List<T> list, int p, int r, Comparator<T> comparator) {
        T x = list.get(r);

        int i = p - 1;

        for (int j = p; j < r; j++) {
            if (comparator.compare(list.get(j), x) < 0) {
                i++;
                swap(list, i, j);
            }
        }

        swap(list, i + 1, r);

        return i + 1;
    }
}
