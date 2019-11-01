package pl.kuglin.algorithm;

import java.util.List;

import static pl.kuglin.Utilities.swap;

public class HeapSort<T extends Comparable<T>> implements SortingAlgorithm<T> {
    @Override
    public void sort(T[] array) {
        buildMaxHeap(array);

        int heapSize = array.length;

        for (int i = array.length - 1; i > 0; i--) {
            swap(array, 0, i);
            maxHeap(array, 0, --heapSize);
        }
    }

    @Override
    public void sort(List<T> list) {
        buildMaxHeap(list);

        int heapSize = list.size();

        for (int i = list.size() - 1; i > 0; i--) {
            swap(list, 0, i);
            maxHeap(list, 0, --heapSize);
        }
    }

    private void buildMaxHeap(T[] array) {
        int heapSize = array.length;

        for (int i = ((heapSize / 2) - 1); i >= 0; i--)
            maxHeap(array, i, heapSize);
    }

    private void buildMaxHeap(List<T> list) {
        int heapSize = list.size();

        for (int i = ((heapSize / 2) - 1); i >= 0; i--)
            maxHeap(list, i, heapSize);
    }

    private void maxHeap(T[] array, int i, int heapSize) {
        int l = left(i);
        int r = right(i);

        int largest;

        if (l < heapSize && array[l].compareTo(array[i]) > 0)
            largest = l;
        else
            largest = i;

        if (r < heapSize && array[r].compareTo(array[largest]) > 0)
            largest = r;

        if (largest != i) {
            swap(array, largest, i);
            maxHeap(array, largest, heapSize);
        }
    }

    private void maxHeap(List<T> list, int i, int heapSize) {
        int l = left(i);
        int r = right(i);

        int largest;

        if (l < heapSize && list.get(l).compareTo(list.get(i)) > 0)
            largest = l;
        else
            largest = i;

        if (r < heapSize && list.get(r).compareTo(list.get(largest)) > 0)
            largest = r;

        if (largest != i) {
            swap(list, largest, i);
            maxHeap(list, largest, heapSize);
        }
    }

    private int left(int i) {
        return 2 * i + 1;
    }

    private int right(int i) {
        return 2 * i + 2;
    }
}
