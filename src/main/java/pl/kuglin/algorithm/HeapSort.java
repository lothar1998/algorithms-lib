package pl.kuglin.algorithm;

import java.util.Comparator;
import java.util.List;

import static pl.kuglin.Utilities.swap;

public class HeapSort<T extends Comparable<T>> implements ComparisonSortingAlgorithm<T> {

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
        buildMaxHeap(array, comparator);

        int heapSize = array.length;

        for (int i = array.length - 1; i > 0; i--) {
            swap(array, 0, i);
            maxHeap(array, 0, --heapSize, comparator);
        }
    }

    @Override
    public void sort(List<T> list, Comparator<T> comparator) {
        buildMaxHeap(list, comparator);

        int heapSize = list.size();

        for (int i = list.size() - 1; i > 0; i--) {
            swap(list, 0, i);
            maxHeap(list, 0, --heapSize, comparator);
        }
    }

    private void buildMaxHeap(T[] array, Comparator<T> comparator) {
        int heapSize = array.length;

        for (int i = ((heapSize / 2) - 1); i >= 0; i--)
            maxHeap(array, i, heapSize, comparator);
    }

    private void buildMaxHeap(List<T> list, Comparator<T> comparator) {
        int heapSize = list.size();

        for (int i = ((heapSize / 2) - 1); i >= 0; i--)
            maxHeap(list, i, heapSize, comparator);
    }

    private void maxHeap(T[] array, int i, int heapSize, Comparator<T> comparator) {
        int l = left(i);
        int r = right(i);

        int largest;

        if (l < heapSize && comparator.compare(array[l], array[i]) > 0)
            largest = l;
        else
            largest = i;

        if (r < heapSize && comparator.compare(array[r], array[largest]) > 0)
            largest = r;

        if (largest != i) {
            swap(array, largest, i);
            maxHeap(array, largest, heapSize, comparator);
        }
    }

    private void maxHeap(List<T> list, int i, int heapSize, Comparator<T> comparator) {
        int l = left(i);
        int r = right(i);

        int largest;

        if (l < heapSize && comparator.compare(list.get(l), list.get(i)) > 0)
            largest = l;
        else
            largest = i;

        if (r < heapSize && comparator.compare(list.get(r), list.get(largest)) > 0)
            largest = r;

        if (largest != i) {
            swap(list, largest, i);
            maxHeap(list, largest, heapSize, comparator);
        }
    }

    private int left(int i) {
        return 2 * i + 1;
    }

    private int right(int i) {
        return 2 * i + 2;
    }
}
