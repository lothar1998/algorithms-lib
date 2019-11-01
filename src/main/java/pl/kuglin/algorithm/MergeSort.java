package pl.kuglin.algorithm;

import java.util.Arrays;
import java.util.List;

public class MergeSort<T extends Comparable<T>> implements SortingAlgorithm<T> {
    @Override
    public void sort(T[] array) {
        mergeSort(array, 0, array.length - 1);
    }

    @Override
    public void sort(List<T> list) {
        mergeSort(list, 0, list.size() - 1);
    }

    private void mergeSort(T[] array, int begin, int end) {
        int q;
        if (begin < end) {
            q = (begin + end) / 2;
            mergeSort(array, begin, q);
            mergeSort(array, q + 1, end);
            merge(array, begin, q, end);
        }
    }

    private void mergeSort(List<T> list, int begin, int end) {
        int q;
        if (begin < end) {
            q = (begin + end) / 2;
            mergeSort(list, begin, q);
            mergeSort(list, q + 1, end);
            merge(list, begin, q, end);
        }
    }

    private void merge(T[] array, int p, int q, int r) {
        int n1 = q - p + 1;
        int n2 = r - q;

        T[] leftArray = Arrays.copyOfRange(array, p, q + 1);
        T[] rightArray = Arrays.copyOfRange(array, q + 1, r + 1);

        int i = 0;
        int j = 0;

        int k = p;

        while (i < n1 && j < n2) {
            if (leftArray[i].compareTo(rightArray[j]) < 0)
                array[k++] = leftArray[i++];
            else
                array[k++] = rightArray[j++];
        }

        if (i == n1) {
            while (j < n2)
                array[k++] = rightArray[j++];
        } else if (j == n2) {
            while (i < n1)
                array[k++] = leftArray[i++];
        }
    }

    private void merge(List<T> list, int p, int q, int r) {
        int n1 = q - p + 1;
        int n2 = r - q;

        List<T> leftList = list.subList(p, q + 1);
        List<T> rightList = list.subList(q + 1, r + 1);

        int i = 0;
        int j = 0;

        int k = p;

        while (i < n1 && j < n2) {
            if (leftList.get(i).compareTo(rightList.get(j)) < 0)
                list.set(k++, leftList.get(i++));
            else
                list.set(k++, rightList.get(j++));
        }

        if (i == n1) {
            while (j < n2)
                list.set(k++, rightList.get(j++));
        } else if (j == n2) {
            while (i < n1)
                list.set(k++, leftList.get(i++));
        }
    }
}
