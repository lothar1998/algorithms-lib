package pl.kuglin.algorithm;

import java.util.List;
import java.util.Random;

import static pl.kuglin.Utilities.swap;

public class QuickSort<T extends Comparable<T>> implements SortingAlgorithm<T> {

    private static Random random = new Random();

    @Override
    public void sort(T[] array) {
        quickSort(array, 0, array.length - 1);
    }

    @Override
    public void sort(List<T> list) {
        quickSort(list, 0, list.size() - 1);
    }

    private void quickSort(T[] array, int p, int r) {
        if (p < r) {
            int q = randomPartition(array, p, r);
            quickSort(array, p, q - 1);
            quickSort(array, q + 1, r);
        }
    }

    private void quickSort(List<T> list, int p, int r) {
        if (p < r) {
            int q = randomPartition(list, p, r);
            quickSort(list, p, q - 1);
            quickSort(list, q + 1, r);
        }
    }

    private int randomPartition(T[] array, int p, int r) {
        swap(array, r, random.nextInt((r - p) + 1) + p);
        return partition(array, p, r);
    }

    private int randomPartition(List<T> list, int p, int r) {
        swap(list, r, random.nextInt((r - p) + 1) + p);
        return partition(list, p, r);
    }

    private int partition(T[] array, int p, int r) {
        T x = array[r];

        int i = p - 1;

        for (int j = p; j < r; j++) {
            if (array[j].compareTo(x) < 0) {
                i++;
                swap(array, i, j);
            }
        }

        swap(array, i + 1, r);

        return i + 1;
    }

    private int partition(List<T> list, int p, int r) {
        T x = list.get(r);

        int i = p - 1;

        for (int j = p; j < r; j++) {
            if (list.get(j).compareTo(x) < 0) {
                i++;
                swap(list, i, j);
            }
        }

        swap(list, i + 1, r);

        return i + 1;
    }
}
