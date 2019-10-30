package pl.kuglin.algorithm;

public class QuickSort<T extends Comparable<T>> implements SortingAlgorithm<T> {
    @Override
    public void sort(T[] array) {
        quickSort(array, 0, array.length - 1);
    }

    private void quickSort(T[] array, int p, int r) {
        if (p < r) {
            int q = partition(array, p, r);
            quickSort(array, p, q - 1);
            quickSort(array, q + 1, r);
        }
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

    private void swap(T[] array, int i, int j) {
        T temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
